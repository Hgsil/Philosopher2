import java.util.Random;

/**
 * Created by Administrator on 2016/11/16 0016.
 */
public class Philosopher implements Runnable{
    volatile boolean stop =false;
    private Chopstick left;
    private Chopstick right;
    private int id;
    private int ponderFacter;
    private Random rand = new Random(47);
    private void pause()throws InterruptedException{
        if (ponderFacter == 0) return;
        Thread.sleep(rand.nextInt(ponderFacter*250));
    }
    public Philosopher(Chopstick left,Chopstick right,int ident,int ponder){
        this.left = left;
        this.right =right;
        id =ident;
        ponderFacter =ponder;
    }
    @Override
    public void run() {
        try {
            while (!stop){
                System.out.println(this+" "+"thinking");
                pause();
                System.out.println(this+" "+"gabbing right");
                right.take();
                System.out.println(this+" "+"gabbing left");
                left.take();
                System.out.println(this+" "+"eating");
                pause();
                right.drop();
                left.drop();
            }
        }catch (Exception e ){      //不输出任何Exception信息,前面所有抛出的异常在这里扔掉，添加输出信息后，输出内容会有报错
        }
    }

    @Override
    public String toString() {
        return "Philosopher" + id ;
    }
}

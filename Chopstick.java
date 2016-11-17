/**
 * Created by Administrator on 2016/11/16 0016.
 */
public class Chopstick {
    private boolean taken =false;
    public synchronized void take() throws InterruptedException{
        while (taken){
            wait();
        }
        taken =true;
    }
    public synchronized void drop(){
        taken =false;
        notifyAll();
    }
}

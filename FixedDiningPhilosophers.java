/**
 * Created by Administrator on 2016/11/17 0017.
 */
public class FixedDiningPhilosophers {                                      //通过改变某人拿筷子的方式来解开死锁
    public static void main(String[] args) throws Exception {
        int ponder = 5;
        int size =5;
        Philosopher[] philosopher = new Philosopher[size];
        Thread[] t =new Thread[size];
        Chopstick[] chopsticks =new Chopstick[size];
        for (int i = 0; i <size ; i++) {
            chopsticks[i] =new Chopstick();
            if ((size-i)!=2)                                    //先拿自己的筷子 再拿左边的筷子
                philosopher[i] = new Philosopher(chopsticks[i],chopsticks[(i+1)%5],i,ponder);
            else                                                //先拿0号的筷子 再拿自己的筷子
                philosopher[i] = new Philosopher(chopsticks[0],chopsticks[i],i,ponder);
        }
        for (int i = 0; i <size ; i++) {
            t[i] =new Thread(philosopher[i]);
            t[i].start();
        }
        Thread.sleep(8000);        //主睡眠时间结束，则让所有线程终止，睡眠时间就是运行的总时间
        for (int i = 0; i <size ; i++) {
            philosopher[i].stop=true;           //改变标志stop，使其跳出循环，结束线程
            t[i].interrupt();
        }

    }

}


package JavaBasic;/**
 * @Classname HighLowPriority
 * @Description TODO
 * @Date 19-5-25 下午1:46
 * @Created by mao<tianmao818@qq.com>
 */
public class HighLowPriority {
    public static void main(String[] args){
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        Clicker high=new Clicker(Thread.NORM_PRIORITY+2);
        Clicker low=new Clicker(Thread.NORM_PRIORITY-2);
        high.start();
        low.start();
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println("Main thread interrupted");
        }
        high.stop();
        low.stop();

//        try{
//            high.t.join();
//            low.t.join();
//        }catch (InterruptedException e){
//            System.out.println("Interrupt exception caught");
//        }
        System.out.println("low priority clicker:"+low.click);
        System.out.println("high priority clicker:"+high.click);
    }

}

class Clicker implements Runnable{
    int click=0;
    Thread t;
    private volatile boolean running=true;
    public Clicker(int p){
        t=new Thread(this);
        t.setPriority(p);
    }
    public void run(){
        while (running){
            click++;
        }
    }
    public void stop(){
        running=false;
    }
    public void start(){
        t.start();
    }
}

package JavaBasic;/**
 * @Classname CurrentThredDemo
 * @Description TODO
 * @Date 19-5-25 下午1:12
 * @Created by mao<tianmao818@qq.com>
 */
public class CurrentThredDemo {
    public static void main(String[] args){

        Thread t=Thread.currentThread();
        System.out.println("current thread:"+t);

        t.setName("TIAN MAO");
        System.out.println("After name change:"+t);
        NewThread tt=new NewThread();
        tt.start();

        new NewThread_1();

        try{
            for(int i=0;i<5;i++){
                System.out.println("main"+i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            System.out.println("interrupted");
        }

        System.out.println("Main Thread exiting...");
    }
}


//不重载Thread的其他方法的时候,使用Runnable
class NewThread implements Runnable{

    Thread t;
    NewThread(){
        t=new Thread(this,"demo thread");
        System.out.println("child thread"+t);
        // 建立新的线程后,并不会直接运行,直到调用了start方法
//        t.start();
    }
    public void start(){
        t.start();
    }
    public void run(){
        try{
            for(int i=0;i<5;i++){
                System.out.println("child 1:"+i);

                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            System.out.println("interrupted");
        }
        System.out.println("exit child 1 thread...");
    }
}

class NewThread_1 extends Thread{
    NewThread_1(){
        super("Demo Thread");
        System.out.println("children"+this);
        start();
    }
    //需要被重载!!!
    public void run(){
        try{
            for(int i=0;i<5;i++){
                System.out.println("child 2:"+i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            System.out.println("interrupted");
        }
        System.out.println("exit child 2 thread...");
    }
}

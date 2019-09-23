package CommonProblems.multithread;/**
 * @Classname DeadLockDemo
 * @Description 死锁Demo
 * @Date 19-6-27 下午3:42
 * @Created by mao<tianmao818@qq.com>
 */
public class DeadLockDemo {
    private static Object resource1=new Object();
    private static Object resource2=new Object();

    public static void main(String[] args){
        new Thread(()->{
            synchronized (resource1){
                System.out.println(Thread.currentThread()+"get resource 1");
                try{
//                    resource1.wait();
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
//                resource2.notify();
                System.out.println(Thread.currentThread()+"wait resource 2");
                synchronized (resource2){
                    System.out.println(Thread.currentThread()+"get resource 2");
                }
            }
        }).start();
        new Thread(()->{
            synchronized (resource2){
                System.out.println(Thread.currentThread()+"get resource 2");
                try{
//                    resource2.wait();
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
//                resource1.notify();
                System.out.println(Thread.currentThread()+"wait resource 1");
                synchronized (resource1){
                    System.out.println(Thread.currentThread()+"wait resource 1");
                }
            }
        }).start();
    }
}

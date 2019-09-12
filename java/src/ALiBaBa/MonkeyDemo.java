package ALiBaBa;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author MaoTian
 * @Classname MonkeyDemo
 * @Description TODO
 * @Date 下午11:15 2019/8/18
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */


class Resource{
    private int num=1119;
    private ReentrantLock lock=new ReentrantLock();
    private Condition condition1=lock.newCondition();

    public void consumer(int k){
        lock.lock();
        try{
            if(num-k<0){
                condition1.await();
            }
            num=num-k;
            if(k==2){
                System.out.println("monkey A:"+k+",left:"+num);
            }else{
                System.out.println("monkey B:"+k+",left:"+num);
            }
//            condition1.notifyAll();
        }catch(Exception e){

        }finally{
            lock.unlock();
        }
    }
}

public class MonkeyDemo {
    public static void main(String[] args)throws Exception {
        Resource resource=new Resource();
        new Thread(()->{
            while (true) {
                resource.consumer(2);
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"monkey A").start();

        new Thread(()->{
            while(true) {
                resource.consumer(3);
                try {
                    TimeUnit.MILLISECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"monkey B").start();

        new Thread(()->{
            while(true) {
                resource.consumer(3);
                try {
                    TimeUnit.MILLISECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"monkey C").start();
    }

}

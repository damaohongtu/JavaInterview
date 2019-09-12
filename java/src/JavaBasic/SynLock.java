package JavaBasic;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname SynLock
 * @Description 使用Lock对象来实现同步机制
 * @Date 19-5-25 下午4:04
 * @Created by mao<tianmao818@qq.com>
 */

class Callme_1{

    private Lock lock=new ReentrantLock();

    void call(String msg){
        lock.lock();
        try{
            System.out.print("lock: ["+msg);
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                System.out.println("Interrupted");
            }
            System.out.println("]");
        }finally {
            lock.unlock();
        }
    }
}

class Caller_1 implements Runnable{
    String msg;
    Callme_1 target;
    Thread t;
    public Caller_1(Callme_1 tar,String s){
        target=tar;
        msg=s;
        t=new Thread(this);
        t.start();
    }
    public void run(){
        target.call(msg);
    }
}

public class SynLock {
    public static void main(String[] args){
        Callme_1 target=new Callme_1();

        //没有组织三个线程同时调用同一个对象的同一个方法,在call前面加上synchronized关键字
        Caller_1 ob1=new Caller_1(target,"hello");
        Caller_1 ob2=new Caller_1(target,"synchronized");
        Caller_1 ob3=new Caller_1(target,"world");

        try {
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        }catch (InterruptedException e){
            System.out.println("interrupted");
        }

    }
}

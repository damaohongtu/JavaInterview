package ALiBaBa;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author MaoTian
 * @Classname ThreadDemo
 * @Description TODO
 * @Date 下午4:41 2019/8/19
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
class ResourceDemo{

    private volatile int num=0;
    ReentrantLock lock=new ReentrantLock();
    Condition c1=lock.newCondition();
    Condition c2=lock.newCondition();
    Condition c3=lock.newCondition();

    public void printA(){
        lock.lock();
        try{
            while(num!=0){
                c1.await();

            }

            System.out.print("A");
        }catch(Exception e){
        }finally{
            num=1;
            c2.signal();
            lock.unlock();
        }
    }
    public void printB(){
        lock.lock();
        try{
            while(num!=1){
                c2.await();
            }

            System.out.print("B");
        }catch(Exception e){
        }finally{
            num=2;
            c3.signal();
            lock.unlock();
        }
    }
    public void printC(){
        lock.lock();
        try{
            while(num!=2){
                c3.await();
            }
            System.out.print("C");
        }catch(Exception e){
        }finally{
            num=0;
            c1.signal();
            lock.unlock();
        }
    }
}

public class ThreadDemo{
    public static void main(String[] args){
        ResourceDemo resourceDemo=new ResourceDemo();

        new Thread(()->{
            for(int i=0;i<10;i++){
                resourceDemo.printA();
            }
        },"Thread A").start();

        new Thread(()->{
            for(int i=0;i<10;i++){
                resourceDemo.printB();
            }
        },"Thread B").start();

        new Thread(()->{
            for(int i=0;i<10;i++){
                resourceDemo.printC();
            }
        },"Thread C").start();
    }
}
package CommonProblems.multithread.pc;/**
 * @Classname PC
 * @Description 线程间通信:生产者+消费者
 * @Date 19-5-25 下午2:29
 * @Created by mao<tianmao818@qq.com>
 */


class Q{
    int n;

    boolean flag=false;

    //尽管使用了同步机制,但是并不能够保证程序运行的先后顺序,需要使用线程之间的通信机制
    synchronized int get(){
        if (!flag){
            try {
                wait();
            }catch (InterruptedException e){
                System.out.println("interrupted");
            }
        }

        System.out.println("Got:"+n);
        flag=false;
        notify();
        return n;
    }

    synchronized void put(int n){
        if(flag){
            try {
                wait();
            }catch (InterruptedException e){
                System.out.println("interrupted");
            }
        }

        this.n=n;
        flag=true;
        System.out.println("Put:"+n);
        notify();
    }
}

class Producer implements Runnable{
    Q q;
    Producer(Q q){
        this.q=q;
        new Thread(this,"Producer").start();

    }
    public void run(){
        int i=0;
        while (true){
            q.put(i++);
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                System.out.println("Main thread interrupted");
            }
        }
    }
}

class Consumer implements Runnable{
    Q q;
    Consumer(Q q){
        this.q=q;
        new Thread(this,"Consumer").start();
    }
    public void run(){
        while (true){
            q.get();
        }
    }
}

public class PC {
    public static void main(String[] args){
        Q q=new Q();
        new Producer(q);
        new Consumer(q);
    }
}

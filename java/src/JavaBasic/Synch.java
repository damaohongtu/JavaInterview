package JavaBasic;/**
 * @Classname Synch
 * @Description 对于同步的理解
 * @Date 19-5-25 下午1:57
 * @Created by mao<tianmao818@qq.com>
 */

class Callme{
//    synchronized void call(String msg){
    void call(String msg){
        System.out.print("["+msg);
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println("Interrupted");
        }
        System.out.println("]");
    }

    //假设这是第二方的代码,不能使用synchronized关键字修饰

}

class Caller implements Runnable{
    String msg;
    Callme target;
    Thread t;
    public Caller(Callme tar,String s){
        target=tar;
        msg=s;
        t=new Thread(this);
        t.start();
    }
    public void run(){
        target.call(msg);
    }
}

class Caller_2 implements Runnable{
    String msg;
    Callme target;
    Thread t;
    public Caller_2(Callme tar,String s){
        target=tar;
        msg=s;
        t=new Thread(this);
        t.start();
    }
    public void run(){
        synchronized (target){
            target.call(msg);
        }

    }
}



public class Synch {
    public static void main(String[] args){
        Callme target=new Callme();

        //没有组织三个线程同时调用同一个对象的同一个方法,在call前面加上synchronized关键字
        Caller ob1=new Caller(target,"hello");
        Caller ob2=new Caller(target,"synchronized");
        Caller ob3=new Caller(target,"world");

        try {
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        }catch (InterruptedException e){
            System.out.println("interrupted");
        }

        Caller_2 ob11=new Caller_2(target,"hello");
        Caller_2 ob22=new Caller_2(target,"synchronized");
        Caller_2 ob33=new Caller_2(target,"world");

        try {
            ob11.t.join();
            ob22.t.join();
            ob33.t.join();
        }catch (InterruptedException e){
            System.out.println("interrupted");
        }


    }
}

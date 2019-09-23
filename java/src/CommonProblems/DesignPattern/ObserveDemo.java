package CommonProblems.DesignPattern;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @Author MaoTian
 * @Classname ObserveDemo
 * @Description 观察者模式
 * 简单情形：有A、B、C、D等四个独立的对象，
 * 其中B、C、D这三个对象想在A对象发生改变的第一时间知道这种改变，以便做出相应的响应或者对策。
 * （1）java.util.Observable
 * Observable就是可以被观察的，程序中的被观察者类，需要继承这个类。
 * （2）
 * java.util.Observer
 * 这个是观察者，是接口。程序中的观察者类，需要实现这个接口中的update()方法。
 *
 * @Date 上午10:17 2019/8/17
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */

class NumObservable extends Observable{
    private int data=0;
    public void setData(int i){
        this.data=i;
        setChanged();
        notifyObservers();
    }
    public int getData(){
        return data;
    }

}

class NumObserver implements Observer {
    public void update(Observable o,Object arg){
        NumObservable numObservable=(NumObservable)o;
        System.out.println("changed:"+arg+","+numObservable.getData());
    }
}

public class ObserveDemo {

    public static void main(String[] args) {
    }

    @Test
    public void check() throws InterruptedException {
        NumObservable number = new NumObservable();    //被观察者对象
        NumObserver observer1=new NumObserver();
        NumObserver observer2=new NumObserver();
        NumObserver observer3=new NumObserver();

        number.addObserver(observer1);    //给number这个被观察者添加观察者(当然可以有多个观察者)
        number.addObserver(observer2);
        number.addObserver(observer3);

        number.setData(1);
        TimeUnit.SECONDS.sleep(1);
        number.setData(2);
        TimeUnit.SECONDS.sleep(1);
        number.setData(3);
    }
}

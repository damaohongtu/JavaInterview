package CommonProblems.mathdemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author MaoTian
 * @Classname MathDemo
 * @Description TODO
 * @Date 上午11:30 2019/9/17
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class FloorCeilRound {
    @Test
    public void test1(List<Object> t){
        System.out.println(Math.floor(-11.5));
        System.out.println(Math.floor(11.5));
        System.out.println(Math.ceil(-11.5));
        System.out.println(Math.ceil(11.5));

        System.out.println(Math.round(-11.4));
        System.out.println(Math.round(-11.6));

    }
    @Test
    public void test2(){
        Object o=new String();
        //List<Object> tmp=new ArrayList<String>();
        List<? extends Object> tmp=new ArrayList<String>();
        synchronized(o) {

        };
    }
    synchronized public int test3(){
        return 0;
    }
}

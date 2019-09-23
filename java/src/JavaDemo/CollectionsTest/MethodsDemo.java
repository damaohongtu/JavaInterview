//package JavaDemo.CollectionsTest;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.LinkedList;
//
//import static CollectionsTest.HashMapTest.MAXIMUM_CAPACITY;
//
///**
// * @Author MaoTian
// * @Classname MethodsDemo
// * @Description TODO
// * @Date 上午10:24 2019/8/13
// * @Version 1.0
// * @Created by mao<tianmao818@qq.com>
// */
//public class MethodsDemo{
//
//    //HashMap保证大小为2幂次方
//    static final int tableSizeFor(int cap) {
//        int n = cap-1;
//        n |= n >>> 1;
//        n |= n >>> 2;
//        n |= n >>> 4;
//        n |= n >>> 8;
//        n |= n >>> 16;
//        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
//    }
//
//    public static void main(String[] args) {
////        System.out.println(tableSizeFor(100));
//
//        Thread a=new Thread(()->{
//        });
//        a.start();
//        a.start();
//
//    }
//}

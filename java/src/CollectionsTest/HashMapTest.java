package CollectionsTest;

import java.util.HashMap;

/**
 * @Classname HashMapTest
 * @Description TODO
 * @Date 19-7-13 上午11:58
 * @Created by mao<tianmao818@qq.com>
 */
public class HashMapTest {
    public static int MAXIMUM_CAPACITY=100000000;
    static final int tableSizeFor(int cap) {

        System.out.println(Integer.toBinaryString(cap));
        int n = cap - 1;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 1;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 2;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 4;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 8;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 16;
        System.out.println(Integer.toBinaryString(n));
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    private static HashMap<Integer,String> map = new HashMap<Integer,String>(2,0.75f);
    public static void main(String[] args){
        System.out.println(Integer.toBinaryString(tableSizeFor(100)));
        map.put(5,"C");

        new Thread("Thread1") {
            public void run() {
                map.put(7, "B");
                System.out.println(map);
            };
        }.start();
        new Thread("Thread2") {
            public void run() {
                map.put(3, "A");
                System.out.println(map);
            };
        }.start();
    }
}

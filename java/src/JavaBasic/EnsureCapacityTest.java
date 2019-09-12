package JavaBasic;

import java.util.ArrayList;

/**
 * @Classname EnsureCapacityTest
 * @Description 测试ArrayList容量的大小
 * @Date 19-7-6 上午10:38
 * @Created by mao<tianmao818@qq.com>
 */

public class EnsureCapacityTest {
    public static void main(String[] args) {

        ArrayList<Object> list = new ArrayList<Object>();
        final int N = 10000000;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("使用ensureCapacity方法前："+(endTime - startTime));

        list = new ArrayList<Object>();
        long startTime1 = System.currentTimeMillis();
        list.ensureCapacity(N);
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("使用ensureCapacity方法后："+(endTime1 - startTime1));
    }
}

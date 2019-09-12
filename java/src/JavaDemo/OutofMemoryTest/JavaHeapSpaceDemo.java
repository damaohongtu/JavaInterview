package JavaDemo.OutofMemoryTest;

/**
 * @Author MaoTian
 * @Classname JavaHeapSpaceDemo
 * @Description 测试堆空间溢出，将这个类的堆大小设置为10m  -Xms10m -Xmx10m
 * @Date 下午10:58 2019/8/12
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class JavaHeapSpaceDemo {
    public static void main(String[] args) {
        byte[] test=new byte[1024*1024*10];
    }
}

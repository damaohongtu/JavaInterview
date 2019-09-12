package JavaDemo.OutofMemoryTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author MaoTian
 * @Classname MetaspaceDemo
 * @Description TODO
 *
 * -XX:+PrintFlagsInitial
 * 永久代：
 * 虚拟机加载的类信息
 * 常量
 * 静态变量
 * 即时编译器后的代码
 * @Date 上午9:04 2019/8/13
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class MetaspaceDemo {
    static class OOMTest{

    }
    public static void main(String[] args) {
        int i=0;
        try {
            while (true){
                i++;
                ArrayList arrayList;
                HashMap hashMap;
                ConcurrentHashMap concurrentHashMap;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

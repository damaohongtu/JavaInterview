package JavaDemo.OutofMemoryTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author MaoTian
 * @Classname GCOverHeadLimitExceededDemo
 * @Description GC  GC占用了太多的资源98%      -Xms10m -Xmx10m -XX:MaxDirectMemorySize=5m
 * @Date 下午11:13 2019/8/12
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class GCOverHeadLimitExceededDemo {
    public static void main(String[] args) {
        int i=0;
        List<String> list=new ArrayList<>();
        try {
            while (true){
                list.add(String.valueOf(++i).intern());
            }
        } catch (Exception e) {
            System.out.println(i);
            e.printStackTrace();
            throw e;
        }
    }
}

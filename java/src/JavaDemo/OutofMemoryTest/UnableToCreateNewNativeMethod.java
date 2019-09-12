package JavaDemo.OutofMemoryTest;

/**
 * @Author MaoTian
 * @Classname UnableToCreateNewNativeMethod
 * @Description TODO
 * @Date 上午8:52 2019/8/13
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class UnableToCreateNewNativeMethod {
    public static void main(String[] args) {
        for(int i=0;;i++){
            new Thread(()->{
                try {
                    Thread.sleep(Integer.MAX_VALUE);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            },i+"").start();
        }
    }
}

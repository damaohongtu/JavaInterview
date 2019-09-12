package JavaBasic;

/**
 * @Author MaoTian
 * @Classname Singleton2
 * @Description 静态内部类
 * @Date 上午11:05 2019/8/11
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class Singleton2 {
    private static final class SingleHandler{
        private static final Singleton2 INSTANCE=new Singleton2();
    }
    private Singleton2(){}
    public static Singleton2 getInstance(){
        return SingleHandler.INSTANCE;
    }
}

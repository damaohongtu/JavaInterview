package JavaBasic;

import java.util.ArrayList;
import java.util.concurrent.Executors;

/**
 * @Classname Singleton
 * @Description 实现单例模式
 * @Date 19-6-27 下午2:12
 * @Created by mao<tianmao818@qq.com>
 */
public class Singleton {
    private volatile static Singleton uniqueInstance;
    private Singleton(){}
    public static Singleton getUniqueInstance(){
        if(uniqueInstance==null){
            synchronized (Singleton.class){
                if(uniqueInstance==null){
                    uniqueInstance=new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}

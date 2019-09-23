package CommonProblems.DesignPattern;

/**
 * @Author MaoTian
 * @Classname SingleTonDemo
 * @Description 单例模式
 * @Date 上午10:47 2019/8/17
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */

class SingleTon1{
    private static volatile SingleTon1 INSTANCE;
    private SingleTon1(){
    }
    public static SingleTon1 getINSTANCE(){
        if(INSTANCE==null){
            synchronized (SingleTon1.class){
                if(INSTANCE==null){
                    INSTANCE=new SingleTon1();
                }
            }
        }
        return INSTANCE;
    }
}
class SingleTon2{
    private static final class SingleHandler{
        private static final SingleTon2 INSTANCE=new SingleTon2();
    }
    private SingleTon2(){}
    public static SingleTon2 getInstance(){
        return SingleHandler.INSTANCE;
    }
}


public class SingleTonDemo {
}

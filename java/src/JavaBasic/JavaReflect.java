package JavaBasic;
import java.lang.reflect.InvocationTargetException;
/**
 * @Classname JavaReflect
 * @Description
 * @Date 19-7-24 下午6:59
 * @Created by mao<tianmao818@qq.com>
 */
public class JavaReflect {

    public static void main(String[] args) throws ClassNotFoundException,
            InstantiationException,IllegalAccessException,
            NoSuchMethodException, InvocationTargetException {

        //获取类
        //第一种
        Class clazz1=new Test().getClass();
        System.out.println(clazz1);
        //第二种
        Class clazz2=Test.class;
        System.out.println(clazz2);
        //第三种
        Class clazz3=Class.forName("JavaBasic.Test");
        System.out.println(clazz3);
        //动态创建对象
        //方法1
        Test obj1=(Test)clazz1.newInstance();
        System.out.println(obj1);
        //方法2
        Test obj2=(Test)clazz1.getConstructor().newInstance();
        System.out.println(obj2);
    }
}
class Test{
    public Test(){
    }
}

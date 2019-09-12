package JavaDemo.VMTest.ReflectDemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author MaoTian
 * @Classname ReflectTest
 * @Description 3种获取Class对象的方式
 * @Date 下午7:43 2019/8/13
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */

public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {

        //第1种方式获取Class对象
        Person p1=new Person();
        Class clazz1=p1.getClass();
        System.out.println(clazz1);

        //第2种方式获取Class对象
        Class clazz2=Person.class;
        System.out.println(clazz2);

        //第3种方式获取Class对象
        Class clazz3=Class.forName("JavaDemo.VMTest.ReflectDemo.Person");//全类名
        System.out.println(clazz3);

        System.out.println("====================Class对象============================");
        //检查Class对象
        System.out.println(clazz1==clazz2);
        System.out.println(clazz2==clazz3);
        System.out.println("=======================构造器=========================");

        Class clazz=Person.class;
        //获取Person类所有公共构造
        Constructor[] conarr=clazz.getConstructors();

        for(Constructor con :conarr){
            System.out.println(con);
        }
        //获取指定构造方法
        //无参数
        Constructor cc=clazz.getConstructor();
        Object oo=cc.newInstance();

        //有参数
        Constructor cc2=clazz.getConstructor(int.class,int.class,String.class);
        Object oo2=cc2.newInstance(1,2,"haha");

        //获取私有构造方法
        Constructor cc3=clazz.getDeclaredConstructor(int.class);
        //暴力访问
        cc3.setAccessible(true);
        Object oo3=cc3.newInstance(1);

        clazz.newInstance();//直接获取空参数构造，必须是public

        System.out.println("=======================成员变量=========================");

        Class clazz4 = Person.class;
        Object obj = clazz4.newInstance();
        // 获取Person类所有 公共 成员变量
        Field[] fields = clazz.getFields();
        for(Field s:fields){
            System.out.println(s);
        }

        Field field=clazz.getField("name");

        field.set(obj, "haha");

        System.out.println(obj);

        Field field2=clazz.getDeclaredField("idcard");
        field2.setAccessible(true);
        field2.set(obj, "123456");
        System.out.println(obj);

        System.out.println("=======================成员方法=========================");
        Class clazz5 = Person.class;
        Object obj2 = clazz5.newInstance();

        // 获取Person类所有 公共 成员方法
        Method[] methods=clazz.getMethods();

        for(Method m:methods){
            System.out.println(m);
        }

        Method m=clazz.getMethod("show");
        m.invoke(obj);

        Method m1=clazz.getMethod("show",int.class);
        m1.invoke(obj,1);

        Method m2=clazz.getDeclaredMethod("show",String.class);
        m2.setAccessible(true);
        m2.invoke(obj,"smt");

    }
}

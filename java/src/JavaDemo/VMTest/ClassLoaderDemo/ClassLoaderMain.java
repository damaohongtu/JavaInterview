package JavaDemo.VMTest.ClassLoaderDemo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author MaoTian
 * @Classname ClassLoaderMain
 * @Description TODO
 * @Date 下午7:06 2019/8/13
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class ClassLoaderMain {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, InvocationTargetException {
        //这个类class的路径
        String classPath = "/home/mao/workspace/java/out/production/java/JavaDemo/VMTest/ClassLoaderDemo/Log.class";

        MyClassLoader myClassLoader = new MyClassLoader(classPath);

        //类的全称
        String packageNamePath = "JavaDemo.VMTest.ClassLoaderDemo.Log";
        //加载Log这个class文件
        Class<?> Log = myClassLoader.loadClass(packageNamePath);

        System.out.println("类加载器是:" + Log.getClassLoader());

        //利用反射获取main方法
        Method method = Log.getDeclaredMethod("main", String[].class);
        Object object = Log.newInstance();
        String[] arg = {"ad"};
        method.invoke(object, (Object) arg);
    }
}

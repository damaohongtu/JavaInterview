package JavaDemo.VMTest.DiamondDependency;

import JavaDemo.VMTest.ClassLoaderDemo.MyClassLoader;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @Author MaoTian
 * @Classname DiamondDependencyTest
 * @Description TODO
 * @Date 下午8:49 2019/8/13
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class DiamondDependencyTest {
    public static void main(String[] args) throws MalformedURLException,
            ClassNotFoundException,
            NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException {
        String v1dir = "file:///home/mao/workspace/java/out/production/java/JavaDemo/VMTest/DiamondDependency/v1/";
        String v2dir = "file:///home/mao/workspace/java/out/production/java/JavaDemo/VMTest/DiamondDependency/v2/";
        URLClassLoader v1 = new URLClassLoader(new URL[]{new URL(v1dir)});
        URLClassLoader v2 = new URLClassLoader(new URL[]{new URL(v2dir)});


        Class<?> depv1Class = v1.loadClass("JavaDemo.VMTest.DiamondDependency.v1.Dep");
        Object depv1 = depv1Class.getConstructor().newInstance();
        depv1Class.getMethod("print").invoke(depv1);

        Class<?> depv2Class = v2.loadClass("JavaDemo.VMTest.DiamondDependency.v2.Dep");
        Object depv2 = depv2Class.getConstructor().newInstance();
        depv2Class.getMethod("print").invoke(depv2);

        System.out.println(depv1.equals(depv2));
        System.out.println("============================================================================");

        MyClassLoader myClassLoader1=new MyClassLoader("/home/mao/workspace/java/out/production/java/JavaDemo/VMTest/DiamondDependency/v1/Dep.class");
        MyClassLoader myClassLoader2=new MyClassLoader("/home/mao/workspace/java/out/production/java/JavaDemo/VMTest/DiamondDependency/v2/Dep.class");


        Class<?> Class1 = myClassLoader1.loadClass("JavaDemo.VMTest.DiamondDependency.v1.Dep");
        Object mydepv1 = Class1.getConstructor().newInstance();
        Class1.getMethod("print").invoke(depv1);

        Class<?> Class2 = myClassLoader2.loadClass("JavaDemo.VMTest.DiamondDependency.v2.Dep");
        Object mydepv2 = Class2.getConstructor().newInstance();
        Class2.getMethod("print").invoke(depv2);

        System.out.println(mydepv1.equals(mydepv2));

    }
}

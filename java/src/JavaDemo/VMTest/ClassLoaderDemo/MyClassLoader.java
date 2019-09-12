package JavaDemo.VMTest.ClassLoaderDemo;

import java.io.*;

/**
 * @Author MaoTian
 * @Classname MyClassLoader
 * @Description 自定义类加载器，继承ClassLoader，自定义findCLass，使用defineClass返回Class对象
 * @Date 下午7:03 2019/8/13
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class MyClassLoader extends ClassLoader {
    //指定路径
    private String path ;

    public MyClassLoader(String classPath){
        path=classPath;
    }
    /**
     * 重写findClass方法
     * @param name 类的全路径，类比在反射Demo中获取Class对象的三种方式！
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class log = null;
        // 获取该class文件字节码数组
        byte[] classData = getData();

        if (classData != null) {
            // 将class的字节码数组转换成Class类的实例
            log = defineClass(name, classData, 0, classData.length);
        }
        return log;
    }

    /**
     * 将class文件转化为字节码数组
     * @return
     */
    private byte[] getData() {
        File file = new File(path);
        if (file.exists()){
            FileInputStream in = null;
            ByteArrayOutputStream out = null;
            try {
                in = new FileInputStream(file);
                out = new ByteArrayOutputStream();

                byte[] buffer = new byte[1024];
                int size = 0;
                while ((size = in.read(buffer)) != -1) {
                    out.write(buffer, 0, size);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return out.toByteArray();
        }else{
            return null;
        }
    }
}
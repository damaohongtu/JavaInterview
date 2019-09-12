package JavaDemo.IOTest;

import java.io.*;

/**
 * @Author MaoTian
 * @Classname BIOTest
 * @Description 测试BIO的使用
 * @Date 下午7:47 2019/8/7
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class BIOTest{
    public static void main(String[] args) throws IOException {
        FileInputStream fis=null;
        FileOutputStream fos=null;
        try {
            fis = new FileInputStream(new File("/home/mao/workspace/java/src/JavaDemo/IOTest/bio_in"));
            fos = new FileOutputStream(new File("/home/mao/workspace/java/src/JavaDemo/IOTest/bio_out"));
            int ch;
            // 读取到结尾返回-1
            while((ch=fis.read()) != -1){
                System.out.println((char)ch);
                fos.write(ch);
            }
            System.out.println(ch);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null != fos){
                fos.close();
            }
            if(null != fis){
                fis.close();
            }
        }

    }
}

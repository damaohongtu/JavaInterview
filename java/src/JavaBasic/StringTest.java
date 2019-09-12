package JavaBasic;

/**
 * @Author MaoTian
 * @Classname StringTest
 * @Description TODO
 * @Date 上午9:39 2019/8/15
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class StringTest {
    public static void main(String args[]) {
        String s1 = new StringBuilder().append("String").append("Test").toString();
        System.out.println(s1.intern() == s1);

        //当调用 intern 方法时，如果常量池中已经该字符串，则返回池中的字符串；
        // 否则将此字符串添加到常量池中，并返回字符串的引用。
        String s2 = new StringBuilder().append("ja").append("va").toString();
        System.out.println(s2.intern() == s2);
    }
}
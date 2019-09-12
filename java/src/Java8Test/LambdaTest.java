package Java8Test;/**
 * @Classname LambdaTest
 * @Description 测试lambda表达式
 * @Date 19-7-5 上午10:37
 * @Created by mao<tianmao818@qq.com>
 */
public class LambdaTest {


    public static void main(String args[]) {
        int num = 1;
        Converter<Integer, String> s = (param) -> System.out.println(String.valueOf(param + num));
        s.convert(2);  // 输出结果为 3
    }

    public interface Converter<T1, T2> {
        void convert(int i);
    }
}

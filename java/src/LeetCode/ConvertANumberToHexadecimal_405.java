package LeetCode;/**
 * @Classname ConvertANumberToHexadecimal_405
 * @Description 求一个数字的十六进制表示! int是32位表示的,16进制表示为8位
 * @Date 19-6-3 上午8:31
 * @Created by mao<tianmao818@qq.com>
 */
public class ConvertANumberToHexadecimal_405 {
    private String lookUp(int n) {
        if (n < 10) {
            return Integer.toString(n);
        }
        switch (n) {
            case 10 : return "a";
            case 11 : return "b";
            case 12 : return "c";
            case 13 : return "d";
            case 14 : return "e";
        }
        return "f";
    }

    //负数
    private String negative(int num) {

        //值
        num *= -1;
        //减一
        num -= 1;
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            //取反
            int n = 15 - num % 16;
            ans.append(lookUp(n));
            num /= 16;
        }
        return ans.reverse().toString();
    }

    //正数
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        if (num < 0) {
            return negative(num);
        }
        StringBuilder ans = new StringBuilder();
        while (num > 0) {
            ans.append(lookUp(num % 16));
            num /= 16;
        }
        return ans.reverse().toString();
    }
}

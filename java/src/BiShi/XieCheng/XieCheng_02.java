package BiShi.XieCheng;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Author MaoTian
 * @Classname XieCheng_01
 * @Description TODO
 * @Date 下午6:51 2019/9/4
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class XieCheng_02 {

    static String resolve(String expr) {

        if(!check(expr)){
            return null;
        }
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i <expr.length() ; i++) {
            Character c=expr.charAt(i);
            if(c!='('&&c!=')'){
                sb.append(c);
            }
        }
        return sb.reverse().toString();
    }

    public static boolean check(String s){
        Stack<Character> stack=new Stack<>();
        for (int i = 0; i <s.length() ; i++) {
            if(s.charAt(i)=='('){
                stack.push('(');
            }
            if(s.charAt(i)==')'){
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in=new Scanner(new File("/home/mao/workspace/java/src/BiShi/XieCheng/test2"));
        //Scanner sc=new Scanner(System.in);
        String res;

        String _expr;
        try {
            _expr = in.nextLine();
        } catch (Exception e) {
            _expr = null;
        }

        res = resolve(_expr);
        System.out.println(res);
    }
}

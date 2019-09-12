package BiShi;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Classname Test_02_HUaWei_02
 * @Description 括号复制内重复问题,对于输入字符串进行括号匹配
 * @Date 19-4-10 下午6:49
 * @Created by mao<tianmao818@qq.com>
 */
public class Test_02_HuaWei_02 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("/home/mao/workspace/java/src/ProgrammingTest/test2"));

        Test_02_HuaWei_02 test=new Test_02_HuaWei_02();
        while(sc.hasNext()){
            String res=test.helper(sc.next());
            System.out.println(res);

        }
    }
    private String helper(String s){
        Stack<Object> stack = new Stack<>();
        int num = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {

                num = num * 10 + c - '0';
            } else if (c == '[') {
                //压入重复数字
                stack.push(num);
                num = 0;
            } else if (c == ']') {
                String st = popStack(stack);

                //中间的重复入栈
                stack.push(st);
            } else {
                //压入字符
                stack.push(c);
            }
        }
        return popStack(stack);
    }


    private String popStack(Stack<Object> stack) {
        //保存字符串的临时栈,主要用于改变方向
        Stack<Object> buffer = new Stack<>();
        StringBuilder sb = new StringBuilder();

        //取出所有的字符,直到数字为止
        while (!stack.isEmpty() && !(stack.peek() instanceof Integer)) {
            buffer.push(stack.pop());
        }

        //改变顺序
        while (!buffer.isEmpty()) {
            sb.append(buffer.pop());
        }

        //重复次数
        int cnt = stack.isEmpty() ? 1 : (int) stack.pop();
        if (cnt == 0) {
            return "";
        }
        String tmp = sb.toString();
        //重复
        for (int i = 0; i < cnt - 1; ++i) {
            sb.append(tmp);
        }
        return sb.toString();
    }
}

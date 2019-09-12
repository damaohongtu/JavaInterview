package LeetCode;

import java.util.Stack;

/**
 * @Classname DecodeString_394
 * @Description 华为的机试题目........扎心了........
 *
 *
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 *
 * 思路:使用栈解决
 * @Date 19-5-20 下午1:29
 * @Created by mao<tianmao818@qq.com>
 */
public class DecodeString_394 {
    public String decodeString(String s) {
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

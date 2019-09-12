package LeetCode;

import java.util.Stack;

/**
 * @Classname LongestValidParentheses_32
 * @Description TODO 最长的括号匹配子串
 * @Date 19-5-9 下午10:48
 * @Created by mao<tianmao818@qq.com>
 */
public class LongestValidParentheses_32 {
    public static int longestValidParentheses(String s) {

        if (s.length() == 0 || s == ""){
            return 0;
        }

        Stack<Integer> st = new Stack<>();
        st.push(-1);

        //保存结果
        int max = 0;

        for (int i = 0; i < s.length(); i++) {

            if (st.peek() == -1){
                st.push(i);
            } else {
                char curr = s.charAt(i);
                char prevFromStack = s.charAt(st.peek());
                //当前这一对匹配成功
                if (curr == ')' && prevFromStack == '(') {
                    st.pop();

                    //更新max
                    max = Math.max(max, i - st.peek());
                }
                //匹配不成功,加入新的索引
                else{
                    st.push(i);
                }
            }

        }

        return max;
    }
    public static void main(String[] args){
        String test1="(()";
        String test2=")()())";
        System.out.println(longestValidParentheses(test1));
        System.out.print(longestValidParentheses((test2)));
    }
}

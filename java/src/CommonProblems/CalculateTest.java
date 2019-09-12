package CommonProblems;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Stack;

/**
 * @Author MaoTian
 * @Classname CalculateTest
 * @Description TODO
 * @Date 下午7:43 2019/8/14
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class CalculateTest {
    public int calculate(String s) {

        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("nashorn");
        String result = "";
        try {
            result = String.valueOf(scriptEngine.eval(s));
        } catch (ScriptException e) {
            e.printStackTrace();
        }

        return Integer.parseInt(result);
    }


    public int calculate3(String s) {
        Stack<Character> op = new Stack<>();
        Stack<Integer> res = new Stack<>();
        int t = 0, ans = 0;
        for (int i = 0; i < s.length(); i++) {

            //!!!
            if (isDigit(s.charAt(i))) {
                t = t * 10 + s.charAt(i) - '0';
                continue;
            }
            if (s.charAt(i) == ' ') continue;

            if(!op.isEmpty()&&((op.peek()=='*')||op.peek()=='/')){
                t=op.pop()=='*'?t*res.pop():res.pop()/t;
            }
            if(!op.isEmpty()&&(op.peek()=='-')){
                t=0-t;
                op.pop();
            }

            res.push(t);
            t=0;
            op.push(s.charAt(i));
        }

        if(!op.isEmpty()&&((op.peek()=='*')||op.peek()=='/')){
            t=op.pop()=='*'?t*res.pop():res.pop()/t;
        }
        if(!op.isEmpty()&&(op.peek()=='-')){
            t=0-t;
            op.pop();
        }

        res.push(t);

        for(int i:res){
            ans+=i;
        }

        return ans;
    }

    public boolean isDigit(char c) {
        return (c - '0') >= 0 && (c - '0') <= 9;
    }

    public static void main(String[] args) {
        CalculateTest calculateTest = new CalculateTest();
        System.out.println(calculateTest.calculate3("-1*2*3*4"));

    }
}

package LeetCode;

import java.util.Stack;

/**
 * @Classname BasicCalculatorII
 * @Description TODO
 * @Date 19-2-27 下午7:27
 * @Created by mao<tianmao818@qq.com>
 */
public class BasicCalculatorII {
    public int calculate(String s) {
        int result=0;
        Stack<Integer> nums=new Stack<>();
        Stack<Character> operator=new Stack<>();
        int flag=0;
        for(int i=0;i<s.length();i++){

            if(checkNum(s.charAt(i))){
                int temp=s.charAt(i)-'0';

                while (i<s.length()-1 && checkNum(s.charAt(++i))){
                    temp=temp*10+s.charAt(i)-'0';
                }
                if(flag==1){
                    temp=temp*-1;
                    flag=0;
                }
                if(!operator.isEmpty()){
                    char c=operator.peek();
                    if(checkOp(c)){
                        int a=nums.peek();
                        nums.pop();
                        operator.pop();
                        if(c=='*'){
                            temp=a*temp;
                        }
                        if(c=='/'){
                            temp=a/temp;
                        }
                        nums.push(temp);
                    }
                }else {
                    nums.push(temp);
                }


            }
            if(checkOp(s.charAt(i))){
                operator.push(s.charAt(i));
            }
            if(s.charAt(i)=='-'){
                System.out.println("negative");
                flag=1;
            }

        }
        for(Integer x:nums){
            result+=x;
        }
        return result;
    }
    public boolean checkNum(char c){
        if('0'<=c && c<='9'){
            return true;
        }
        return false;
    }
    public boolean checkOp(char c){
        if(c=='*' || c=='/'){
            return true;
        }
        return false;
    }
    public static void main(String[] args){
        BasicCalculatorII basicCalculatorII=new BasicCalculatorII();
        System.out.println(basicCalculatorII.calculate("3*40-2/2"));
    }
}
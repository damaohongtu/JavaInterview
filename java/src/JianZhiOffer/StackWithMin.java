package JianZhiOffer;

import java.util.Stack;

/**
 * @Classname StackWithMin
 * @Description 使用一个Stack来进行辅助!!!
 * @Date 19-3-3 上午11:13
 * @Created by mao<tianmao818@qq.com>
 */
public class StackWithMin{
    private Stack<Integer> stack_data=new Stack<>();
    private Stack<Integer> stack_min=new Stack<>();
    public void push1(Integer t){
        stack_data.push(t);
        if(stack_min.size()<1 || t<stack_min.peek()){
            stack_min.push(t);
        }else{
            stack_min.push(stack_min.peek());
        }
    }
    public void pop(){
        stack_data.pop();
        stack_min.pop();
    }
    public int min1(){
        return stack_min.peek();
    }
    public static void main(String[] args){
        StackWithMin stackWithMin=new StackWithMin();
        stackWithMin.push1(1);
        stackWithMin.push1(2);
        stackWithMin.push1(3);
        stackWithMin.push1(4);
        System.out.println(stackWithMin.min1());
        System.out.println(stackWithMin.min1());
        System.out.println(stackWithMin.min1());
        System.out.println(stackWithMin.min1());
    }

}
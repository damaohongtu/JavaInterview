package JianZhiOffer;

import java.util.Stack;

/**
 * @Classname Stack4Queue
 * @Description TODO
 * @Date 19-3-2 下午3:33
 * @Created by mao<tianmao818@qq.com>
 */
public class Stack4Queue<T> {
    private Stack<T> stack1=new Stack<>();
    private  Stack<T> stack2=new Stack<>();
    public void append(T t){
        stack1.push(t);
    }
    public T delete(){
        if(stack2.size()<=0){
            while (stack1.size()>0){
                T data=stack1.peek();
                stack1.pop();
                stack2.push(data);
            }
        }
        T head=stack2.peek();
        stack2.pop();
        return head;
    }
    public static void main(String[] args){
        Stack4Queue stack4Queue=new Stack4Queue();
        stack4Queue.append("lingyun");
        stack4Queue.append("mao");
        stack4Queue.append("forever");

        System.out.println(stack4Queue.delete());
        System.out.println(stack4Queue.delete());
        System.out.println(stack4Queue.delete());
    }
}
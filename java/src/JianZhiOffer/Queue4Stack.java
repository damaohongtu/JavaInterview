package JianZhiOffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname Queue4Stack
 * @Description 从一个queue将元素进行转移,仅仅留下最后一个元素,将这个元素弹出去!
 * @Date 19-3-2 下午3:33
 * @Created by mao<tianmao818@qq.com>
 */
public class Queue4Stack<T> {
    private Queue<T> queue1=new LinkedList<>();
    private Queue<T> queue2=new LinkedList<>();
    public void append(T t){
        queue1.add(t);
    }
    public T delete(){
        while (queue1.size()>1){
            T t= queue1.poll();
            queue2.add(t);
        }
        T head=queue1.poll();
        Queue<T> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return head;
    }
    public static void main(String[] args){
        Queue4Stack queue4Stack=new Queue4Stack();
        queue4Stack.append("lingyun");
        queue4Stack.append("mao");
        queue4Stack.append("forever");
        System.out.println(queue4Stack.delete());
        System.out.println(queue4Stack.delete());
        System.out.println(queue4Stack.delete());
    }
}
package BinaryTree;

import java.util.Stack;

/**
 * @Classname StackValidOrder
 * @Description TODO
 * @Date 19-3-2 下午7:47
 * @Created by mao<tianmao818@qq.com>
 */
public class StackValidOrder {
    public boolean isValidOrder(int[] pushOrder,int[] popOrder){
        int length=pushOrder.length;
        boolean possibel=false;
        int pushIndex=0;
        int popIndex=0;
        Stack<Integer> temp=new Stack<>();
        while (popIndex<length){
            while (temp.isEmpty() || temp.peek()!=popOrder[popIndex]){
                if(pushIndex>=length){
                    break;
                }
                temp.add(pushOrder[pushIndex]);
                pushIndex++;

            }
            if(temp.peek()!=popOrder[popIndex]){
                break;
            }
            temp.pop();
            popIndex++;

        }
        if(temp.isEmpty() && popIndex==length){
            possibel=true;
        }
        return possibel;
    }
    public static void main(String[] args){
        StackValidOrder stackValidOrder=new StackValidOrder();
        System.out.println(stackValidOrder.isValidOrder(new int []{1,2,3,4,5},new int[]{4,3,5,1,2}));
    }
}
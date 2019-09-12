package CollectionExercises;

import java.util.*;

public class PriorityQueueExercises {
    public static void main(String[] args){
        //1.建立一个新的priority queue
        PriorityQueue<String> lingyun=new PriorityQueue<>();
        lingyun.add("Good");
        lingyun.add("Luck");
        lingyun.add("pass");
        lingyun.add("the");
        lingyun.add("exam");
        System.out.println("1.1:"+lingyun);
        String[] temp={"lingyun","Good","Luck"};
        PriorityQueue<String> mao=new PriorityQueue<String>(Arrays.asList(temp));
        System.out.println("1.2:"+mao);
        //2.iterate
        System.out.print("2:");
        for (String element:lingyun){
            System.out.print(element+"\t");
        }
        System.out.println();
        //3.将一个queue添加到另外一个
        PriorityQueue<String>lingyun2=new PriorityQueue<>();
        lingyun2.addAll(lingyun);
        System.out.println("3:"+lingyun2);
        //4.添加一个特定值,调用 add() 方法就会抛出一个 unchecked 异常，而调用 offer() 方法会返回 false。
        lingyun.offer("mao@yun");
        System.out.println("4:"+lingyun);
        //5.从一个priority queue中移除所有的值
        mao.removeAll(mao);
        System.out.println("5:"+mao);
        //6.计数
        System.out.println("6:"+lingyun.size());
        //7.比较

        //8.retrieve the first element.
        System.out.println("8:"+lingyun.peek());
        //9.retrieve and remove the first element.
        System.out.println("9:"+lingyun.poll());
        //10.priority queue--->array
        List<String> array_list=new ArrayList<String>(lingyun);
        System.out.println("10:"+array_list);
        //11.priority queue--->string representation
        String lingyun3=lingyun.toString();
        System.out.println("11:"+lingyun3);
        //12.priority queue--->maximum priority queue
        PriorityQueue<Integer> lingyun4= new PriorityQueue<>(5, Collections.reverseOrder());
        lingyun4.add(1);
        lingyun4.add(2);
        lingyun4.add(3);
        lingyun4.add(4);
        lingyun4.add(5);
        System.out.println("12:"+lingyun4);
    }
}

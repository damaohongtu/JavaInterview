package CommonProblems.CollectionExercises;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetExercises {
    public static void main(String[] args){
        //1.建立树,初始化
        TreeSet<String> lingyun=new TreeSet<>();
        lingyun.add("Red");
        lingyun.add("Green");
        lingyun.add("Orange");
        lingyun.add("White");
        lingyun.add("Black");
        System.out.println("1:"+lingyun);
        //2.迭代遍历
        System.out.print("2:");
        for (String element:lingyun){
            System.out.print(element+"\t");
        }
        System.out.println();
        //3.将一个TreeSet添加到了另外一个TreeSet
        TreeSet<String> mao=new TreeSet<>();
        mao.addAll(lingyun);
        System.out.println("3:"+mao);
        //4.reverse
        Iterator it=lingyun.iterator();
        System.out.print("4:");
        while(it.hasNext()){
            System.out.print(it.next()+"\t");
        }
        //5.第一个&最后一个元素
        Object first_element=lingyun.first();
        Object last_elment=lingyun.last();
        System.out.println("5:"+first_element+","+last_elment);
        //6.clone
        TreeSet<String> mao1=(TreeSet<String>)mao.clone();
        System.out.println("6:"+mao1);
        //7.tree set元素数目
        System.out.println("7:"+mao.size());
        //8.比较两个tree set
        System.out.print("8:");
        for(String element:lingyun){
            System.out.print(mao.contains(element)+"\t");
        }
        System.out.println();
        //9.在tree set中寻找小于7的数字
        TreeSet<Integer> lingyun2=new TreeSet<Integer>();
        TreeSet<Integer> mao2=new TreeSet<Integer>();
        lingyun2.add(1);
        lingyun2.add(3);
        lingyun2.add(5);
        lingyun2.add(7);
        lingyun2.add(9);
        mao2=(TreeSet)lingyun2.headSet(7);
        System.out.println("9:"+mao2);
        //10.寻找大于等于给定元素的元素
        System.out.println("10:"+lingyun2.ceiling(6));
        //11.寻找小于等于给定元素的元素
        System.out.println("11:"+lingyun2.floor(6));
        //12.strictly greater or equal to the given element.
        System.out.println("12:"+lingyun2.higher(6));
        //13.strictly less than the given element.
        System.out.println("13:"+lingyun2.lower(6));
        //14.retrieve and remove the first element.
        System.out.println("14:"+lingyun2.pollFirst());
        //15.retrieve and remove the last element.
        System.out.println("15:"+lingyun2.pollLast());
        //16.移除一个tree set中给定的元素
        lingyun2.remove(5);
        System.out.println("16:"+lingyun2);
    }
}

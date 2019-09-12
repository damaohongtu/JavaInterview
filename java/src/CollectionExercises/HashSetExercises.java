package CollectionExercises;

import java.util.*;

public class HashSetExercises {
    public static void main(String[] args){
        //1.建立,初始化
        HashSet<String> lingyun=new HashSet<>();
        lingyun.add("I");
        lingyun.add("miss");
        lingyun.add("you");
        lingyun.add("very");
        lingyun.add("much");
        lingyun.add("much");
        System.out.println("1.1:"+lingyun);
        String[] temp1={"I","miss","you","you"};
        HashSet<String> mao=new HashSet<String>(Arrays.asList(temp1));
        System.out.println("1.2:"+mao);
        //2.迭代遍历
        Iterator p = lingyun.iterator();
        System.out.print("2:");
        while (p.hasNext()){
            System.out.print(p.next()+"\t");
        }
        System.out.println();
        //3.获取元素个数
        System.out.println("3:"+lingyun.size());
        //4.置空
        mao.removeAll(mao);
        System.out.println("4:"+mao);
        //5.判空
        System.out.println("5:"+mao.isEmpty());
        //6.clone
        mao=(HashSet)lingyun.clone();
        System.out.println("6:"+mao);
        //7.hash set ---> array
        String[] lingyun2=new String[lingyun.size()];
        lingyun.toArray(lingyun2);
        System.out.print("7:");
        for (String element:lingyun){
            System.out.print(element+"\t");
        }
        System.out.println();

        //8.hash set ---> tree set
        Set<String> lingyun3=new TreeSet<>(lingyun);
        System.out.println("8:"+lingyun3);
        //9.hash set ---> List/ArrayList
        List<String> mao3= new ArrayList<>(lingyun);
        System.out.println("9:"+mao3);
        //10.比较
        mao.add("mao&lingyun");
        mao.add("forever");
        System.out.print("10:");
        for (String element:mao){
            System.out.print(lingyun.contains(element)+"\t");
        }
        System.out.println();
        //11.比较返回相同元素
        mao.retainAll(lingyun);
        System.out.println("11:"+mao);
        //12.从hash set中删除所有元素
        lingyun.clear();
        mao.removeAll(mao);
        System.out.println("12:"+mao+","+lingyun);
    }
}

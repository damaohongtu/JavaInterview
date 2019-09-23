package CommonProblems.CollectionExercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapExercises {
    public static void main(String[] args){

        //1.新建HashMap,添加元素
        HashMap<Integer,String>lingyun = new HashMap<>();
        lingyun.put(1,"mao&yun");
        lingyun.put(2,"Good");
        lingyun.put(3,"Luck");
        System.out.print("1:");
        for(Map.Entry x:lingyun.entrySet()){
            System.out.print(x.getKey()+":"+x.getValue()+"\t");
        }
        System.out.println();
        //2.size?
        System.out.println("2:"+lingyun.size());
        //3.复制
        HashMap<Integer,String>mao = new HashMap<>();
        mao.putAll(lingyun);
        System.out.println("3:"+mao);
        //4.置空
        mao.clear();
        System.out.println("4:"+mao);
        //5.判空
        System.out.println("5:"+mao.isEmpty());
        //6.get a shallow copy
        HashMap<Integer,String> mao2= new HashMap<Integer,String>();
        mao2=(HashMap)lingyun.clone();
        System.out.println("6:"+mao2);
        //7.判断key是否存在
        System.out.println("7:"+mao2.containsKey(1));
        //8.create a set view of the mappings contained in a map.
        Set set=lingyun.entrySet();
        System.out.println("8:"+set);
        //9.按键取值
        System.out.println("9:"+lingyun.get(1));
        //10.判断value是否存在某个值?
        System.out.println("10:"+mao2.containsValue("mao&yun"));
        //11.to get a set view of the keys contained in this map.
        Set keyset=lingyun.keySet();
        System.out.println("11:"+keyset);
        //12. to get a collection view of the values contained in this map.
        System.out.println("12:"+lingyun.values());
    }
}

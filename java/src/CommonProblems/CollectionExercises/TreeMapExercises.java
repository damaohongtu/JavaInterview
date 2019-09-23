package CommonProblems.CollectionExercises;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapExercises {
    public static void main(String[] argv){
        //1.新建,添加元素
        TreeMap<Integer,String>lingyun=new TreeMap<Integer, String>();
        lingyun.put(1,"mao&yun");
        lingyun.put(2,"Good");
        lingyun.put(3,"Luck");
        System.out.println("1:"+lingyun);
        //2.copy
        TreeMap<Integer,String>mao=new TreeMap<Integer, String>();
        mao.putAll(lingyun);
        System.out.println("2:"+mao);
        //3.search key
        System.out.println("3:"+mao.containsKey(1));
        //4.search value
        System.out.println("4:"+mao.containsValue("mao&yun"));
        //5.get all keys
        System.out.println("5:"+lingyun.keySet());
        //6.delete all elements
        mao.clear();
        System.out.println("6:"+mao);
        //7.sort keys in Tree Map by using comparator.
        TreeMap<String,String>lingyun2=new TreeMap<String,String>(new SortKey());
        lingyun2.put("LM1","mao&yun");
        lingyun2.put("LM3","Luck");
        lingyun2.put("LM2","Good");
        System.out.println("7:"+lingyun2);
        //8.to get a key-value mapping associated with the greatest key and the least key in a map
        System.out.println("8:"+lingyun2.firstEntry()+","+lingyun2.lastEntry());
        //9.to get the first (lowest) key and the last (highest) key currently in a map.
        System.out.println("9:"+lingyun2.firstKey()+","+lingyun2.lastKey());
        //10.to get a reverse order view of the keys contained in a given map.
        System.out.println("10:" + lingyun2.descendingKeySet());
        //11.to get a key-value mapping associated with the greatest key less than or equal to the given key.
        TreeMap<Integer,String>mao2=new TreeMap<>();
        mao2.put(10,"LingYun");
        mao2.put(20,"you");
        mao2.put(30,"the trouble i am in");
        System.out.println("11:" + mao2.floorEntry(10));
        //12. to get the greatest key less than or equal to the given key.
        System.out.println("12:" + mao2.floorKey(10));
        //13.to get the portion of a map whose keys are strictly less than a given key.
        System.out.println("13:" + mao2.floorEntry(10));
        //14.to get the portion of this map whose keys are less than (or equal to, if inclusive is true) a given key.
        System.out.println("14:" + mao2.headMap(10,true));
        //15.to get the least key strictly greater than the given key.
        System.out.println("15:"+mao2.higherEntry(20));
        //16.to get a key-value mapping associated with the greatest key strictly less than the given key.
        System.out.println("16:"+mao2.lowerEntry(20));
        //17.to get the greatest key strictly less than the given key.
        System.out.println("17:" + mao2.lowerKey(30));
        //18.to get NavigableSet view of the keys contained in a map.
        System.out.println("18:"+mao2.navigableKeySet());
        //19.to remove and get a key-value mapping associated with the least key in a map.
        System.out.println("19:"+mao2.pollFirstEntry());
        //20.to remove and get a key-value mapping associated with the greatest key in this map.
        System.out.println("20:"+mao2.pollLastEntry());
        //21. to get the portion of a map whose keys range from a given key (inclusive), to another key (exclusive).
        SortedMap<Integer,String> mao3=new TreeMap<>();
        mao3=mao.subMap(10,20);
        System.out.println("21:"+mao3);
        //22.to get the portion of a map whose keys range from a given key to another key.
        System.out.println("22:"+mao2.subMap(10,true,20,true));
        //23.to get a portion of a map whose keys are greater than or equal to a given key.
        System.out.println("23"+mao2.tailMap(20));
        //24.to get a portion of a map whose keys are greater than to a given key
        System.out.println("24:" + mao2.tailMap(20, false));
        //25.to get a key-value mapping associated with the least key greater than or equal to the given key.
        System.out.println("25:" + mao2.ceilingEntry(20));
        //26.to get the least key greater than or equal to the given key.
        System.out.println("26:" +mao2.ceilingKey(20));
    }

}
class SortKey implements Comparator<String>{
    @Override
    public int compare(String str1,String str2){
        return str1.compareTo(str2);
    }

}
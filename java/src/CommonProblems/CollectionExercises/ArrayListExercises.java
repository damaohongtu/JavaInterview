package CommonProblems.CollectionExercises;

import java.util.*;

public class ArrayListExercises {
    public static void main(String[] args){


        //1.创建ArrayList,添加读取
        List<String> list_string=new ArrayList<String>();
        list_string.add("RED");
        list_string.add("GREEN");
        list_string.add("ORANGE");
        list_string.add("WHITE");
        list_string.add("BLACK");


        //1.创建ArrayList,添加读取
        List<String> list_string2=new ArrayList<String>();
        list_string2.add("1");
        list_string2.add("2");
        list_string2.add("3");
        list_string2.add("4");
        list_string2.add("5");
        list_string2.add("6");
        list_string2.add("7");
        System.out.println("1:"+list_string);
        //2.从ArrayList中迭代所有的元素
        System.out.print("2:");
        for (String color:list_string){
            System.out.print(color+"\t");
        }
        System.out.println();
        //3.在ArrayList的首部插入元素
        list_string.add(0,"PINK");
        list_string.add(5,"YELLOW");
        System.out.println("3:"+list_string);
        //4.按照下标取元素
        System.out.println("4:"+list_string.get(4));
        //5.修改特定元素
        list_string.set(1,"BLUE");
        System.out.println("5:"+list_string);
        //6.删除第n个元素
        list_string.remove(1);
        System.out.println("6:"+list_string);
        //7.查找某一个元素
        System.out.println("7:"+list_string.contains("PINK"));
        //8.排序
        Collections.sort(list_string);
        System.out.println("8:"+list_string);
        //9.复制
        Collections.copy(list_string2,list_string);
        System.out.println("9:"+list_string2);
        //10.shuffle
        Collections.shuffle(list_string);
        System.out.println("10"+list_string);
        //11.reverse
        Collections.reverse(list_string);
        System.out.println("11:"+list_string);
        //12.切片取
        System.out.println("12:"+list_string.subList(0,3));
        //13.比较数组
        //14.交换元素
        Collections.swap(list_string,0,1);
        System.out.println("14:"+list_string);
        //15.join
        list_string2.addAll(list_string);
        System.out.println("15:"+list_string2);
        //16.clone
        ArrayList<String> new1=(ArrayList<String>)((ArrayList<String>) list_string2).clone();
        System.out.println("16:"+new1);
        //17.置空,所以如果你的目的是删除所有元素，用clear(),如果你的目的是删除某些存在于另一集合的元素，那么选择removeAll(Collection c)方法。
        new1.removeAll(new1);
        System.out.println("17:"+new1);
        //18.判断是否为空?
        System.out.println("18:"+new1.isEmpty());
        //19.修剪
        ((ArrayList<String>) list_string2).trimToSize();
        System.out.println("19:"+list_string2);
        //20.增加ArrayList的大小
        ((ArrayList<String>) list_string2).ensureCapacity(6);
        list_string2.add("linyun");
        list_string2.add("mao");
        System.out.println("20:"+list_string2);
        //21.初始化
        Integer[] mao = {1,2,3,4,5,6};

        List<Integer> lingyun1 = new ArrayList();
        Collections.addAll(lingyun1, mao);
        System.out.println("21.1:"+lingyun1);

        List<Integer> lingyun2= Arrays.asList(mao);
        System.out.println("21.2:"+lingyun2);

        List<Integer> lingyun3=new ArrayList();
        lingyun3.addAll(Arrays.asList(mao));
        System.out.println("21.3:"+lingyun3);



    }
}

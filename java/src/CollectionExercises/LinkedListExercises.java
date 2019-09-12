package CollectionExercises;

import java.util.*;

public class LinkedListExercises {
    public static void main(String[] args){
        //1.在尾部插入
        LinkedList<String> lingyun=new LinkedList<String>();
        lingyun.add("Red");
        lingyun.add("Green");
        lingyun.add("Black");
        lingyun.add("White");
        lingyun.add("Pink");
        lingyun.add("Yellow");
        System.out.println("1.1:"+lingyun);
        String[] temp={"1","2","3","4","5","6"};
        LinkedList<String> mao=new LinkedList<String>(Arrays.asList(temp));
        System.out.println("1.2:"+mao);
        //2.迭代
        System.out.print("2:");
        for (String l:lingyun){
            System.out.print(l+"\t");
        }
        System.out.println();
        //3.从特定的位置进行遍历
        Iterator p=lingyun.listIterator(1);
        System.out.print("3:");
        while (p.hasNext()){
            System.out.print(p.next()+"\t");
        }
        System.out.println();
        //4.在特定的位置插入
        lingyun.add(1,"Yellow");
        System.out.println("4:"+lingyun);
        //5.在首尾插入
        lingyun.addFirst("Blue");
        lingyun.addLast("Gold");
        System.out.println("5:"+lingyun);
        //6.在头部插入值
        lingyun.offerFirst("mao");
        System.out.println("6:"+lingyun);
        //7.逆序迭代
        Iterator l_r=lingyun.descendingIterator();
        System.out.print("7:");
        while (l_r.hasNext()){
            System.out.print(l_r.next()+"\t");
        }
        System.out.println();
        //8.在尾部插入
        lingyun.offerLast("mao");
        System.out.println("8:"+lingyun);
        //9.插入多个值
        LinkedList<String>temp2=new LinkedList<>();
        temp2.add("miss");
        temp2.add("you");
        lingyun.addAll(1,temp2);
        System.out.println("9:"+lingyun);
        //10.第一个,最后一个
        Object first=lingyun.getFirst();
        Object last=lingyun.getLast();
        System.out.println("10:"+first+","+last);

        //11.打印元素的位置和值
        System.out.print("11:");
        for (int pp=0;pp<lingyun.size();pp++){
            System.out.print(pp+":"+lingyun.get(pp)+"\t");
        }
        System.out.println();
        //12.删除特定的元素
        lingyun.remove(3);
        System.out.println("12:"+lingyun);
        //13.删除首尾元素
        Object removeFirst=lingyun.removeFirst();
        Object removeLast=lingyun.removeLast();
        System.out.println("13:"+removeFirst+","+removeLast);
        //14.删除所有的元素
        mao.clear();
        System.out.println("14:"+mao);
        //15.交换两个元素
        Collections.swap(lingyun,0,2);
        System.out.println("15:"+lingyun);
        //16.shuffle
        Collections.shuffle(lingyun);
        System.out.println("16:"+lingyun);
        //17.连接两个LinkedList
        mao.addAll(lingyun);
        lingyun.addAll(mao);
        System.out.println("17:"+lingyun);
        //18.clone
        LinkedList<String> mao2=new LinkedList<>();
        mao2=(LinkedList)lingyun.clone();
        System.out.println("18:"+mao2);
        //19.remove and return
        System.out.println("19:"+mao2.pop());
        //20.retrieve but not remove the first element(依然占据位置?)
        System.out.println("19:"+mao2.peekFirst());
        //21.retrieve but not remove the last element
        System.out.println("19:"+mao2.peekLast());
        //22.检查元素是否存在?
        lingyun.add("mao");
        System.out.println("22:"+lingyun.contains("mao"));
        //23.将LinkedList转换为ArrayList
        ArrayList<String> lingyun2=new ArrayList<>(lingyun);
        System.out.println("23:"+lingyun2);
        //24.比较两个ArrayList

        //25.判断是否为空?
        System.out.println("25:"+mao.isEmpty());
        //26.替换元素
        lingyun.set(0,"mao&yun");
        System.out.println("25:"+lingyun);
    }
}

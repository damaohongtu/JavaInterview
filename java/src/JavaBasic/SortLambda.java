package JavaBasic;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Classname SortLambda
 * @Description 使用lambda表达式重写排序方法
 * @Date 19-7-7 下午3:17
 * @Created by mao<tianmao818@qq.com>
 */


class People{
    private String name;
    private int age;
    public People(String name,int age){
        this.name=name;
        this.age=age;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
}

public class SortLambda {
    public static void main(String[] args){
        ArrayList<People> arrayList=new ArrayList<>();
        arrayList.add(new People("test1",25));
        arrayList.add(new People("test3",24));
        arrayList.add(new People("test2",27));
        //按照姓名逆字典排序
        Collections.sort(arrayList,(a,b)->b.getName().compareTo(a.getName()));
//        //按照年龄顺序排序
//        Collections.sort(arrayList,(a,b)->a.getName().compareTo(b.getName()));
        for(People people:arrayList){
            System.out.println(people.getName()+","+people.getAge());
        }
    }
}

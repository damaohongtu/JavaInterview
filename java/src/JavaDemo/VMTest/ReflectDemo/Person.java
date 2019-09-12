package JavaDemo.VMTest.ReflectDemo;

/**
 * @Author MaoTian
 * @Classname Person
 * @Description TODO
 * @Date 下午7:43 2019/8/13
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class Person {

    //构造器
    public Person(){
        System.out.println("Person类无参数构造");
    }
    public Person(int a,int b,String s){
        System.out.println("Person类有参数构造：a:"+a+" b:"+b+" s:"+s);
    }

    private Person(int a){
        System.out.println("Person类有参数私有构造：a:"+a);
    }

    //属性
    public String name="smt";
    private String idcard="1001u09t";

    @Override
    public String toString() {
        return "name:"+name+"  idcard:"+idcard;
    }

    //方法
    public void show(){
        System.out.println("show 空参数");
    }
    public void show(int a){
        System.out.println("show   a:"+a);
    }
    private void show(String s){
        System.out.println("show   s:"+s);
    }
}

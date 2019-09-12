//package JavaBasic;
//
//import org.apache.commons.lang3.builder.EqualsBuilder;
//import org.apache.commons.lang3.builder.HashCodeBuilder;
//
//import java.util.HashMap;
//import java.util.Objects;
//
//
///**
// * @Classname OverideEqualsHashcode
// * @Description 重写equals和hashCode方法
// * @Date 19-7-5 下午4:04
// * @Created by mao<tianmao818@qq.com>
// */
//
//class Person{
//    private String id;
//    public Person(String id){
//        this.id=id;
//    }
//    @Override
//    public boolean equals(Object o){
//
//        if(this==o){
//            return true;
//        }
//        if(o==null||getClass()!=o.getClass()){
//            return false;
//        }
//        Person person=(Person)o;
//
//        if(id!=null?(!id.equals(person.id)):(person.id!=null)){
//            return false;
//        }
//        return true;
//    }
//    @Override
//    public int hashCode(){
//        return id!=null?id.hashCode():0;
//    }
//}
//
//
//class User {
//    private String name;
//    private int age;
//    private String passport;
//
//    //getters and setters, constructor
//
//    @Override
//    public boolean equals(Object o) {
//
//        if (o == this) return true;
//        if (!(o instanceof User)) {
//            return false;
//        }
//
//        User user = (User) o;
//
//        return user.name.equals(name) &&
//                user.age == age &&
//                user.passport.equals(passport);
//    }
//
//    //Idea from effective Java : Item 9
//    @Override
//    public int hashCode() {
//        int result = 17;
//        result = 31 * result + name.hashCode();
//        result = 31 * result + age;
//        result = 31 * result + passport.hashCode();
//        return result;
//    }
//
//}
//
//
//class User_1 {
//    private String name;
//    private int age;
//    private String passport;
//
//    //getters and setters, constructor
//
//    @Override
//    public boolean equals(Object o) {
//
//        if (o == this) return true;
//        if (!(o instanceof User)) {
//            return false;
//        }
//        User_1 user = (User_1) o;
//        return age == user.age &&
//                Objects.equals(name, user.name) &&
//                Objects.equals(passport, user.passport);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, age, passport);
//    }
//
//}
//
//
//class User_2 {
//    private String name;
//    private int age;
//    private String passport;
//
//    //getters and setters, constructor
//
//    @Override
//    public boolean equals(Object o) {
//
//        if (o == this) return true;
//        if (!(o instanceof User_2)) {
//            return false;
//        }
//
//        User_2 user = (User_2) o;
//
//        return new EqualsBuilder()
//                .append(age, user.age)
//                .append(name, user.name)
//                .append(passport, user.passport)
//                .isEquals();
//    }
//
//    @Override
//    public int hashCode() {
//        return new HashCodeBuilder(17, 37)
//                .append(name)
//                .append(age)
//                .append(passport)
//                .toHashCode();
//    }
//
//}
//
//
//public class OverideEqualsHashcode {
//    public static void main(String[] args){
//        HashMap<Person,String> map=new HashMap<>();
//
//        // 如果不重写,将会有四个对象加入,即使对象的信息相同,但是euqals的是对象的地址,新建一个对象地址肯定不一样
//        map.put(new Person("001"),"test1");
//        map.put(new Person("001"),"test2");
//        map.put(new Person("003"),"test3");
//        map.put(new Person("004"),"test4");
//        System.out.println(map.toString());
//
//        // 如果只重写hashCode,hashCode即使一样,对象还是不一样
//        System.out.println((new Person("code1")).hashCode());
//        System.out.println((new Person("code1")).hashCode());
//        System.out.println((new Person("code2")).hashCode());
//    }
//}

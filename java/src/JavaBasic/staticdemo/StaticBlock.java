package JavaBasic.staticdemo;

/**
 * @Classname StaticBlock
 * @Description static修饰代码块
 * @Date 19-7-5 下午8:16
 * @Created by mao<tianmao818@qq.com>
 */

class StaticBlockTest{

    static {
        System.out.println("run");
    }
}

public class StaticBlock {
    public static void main(String[] args){
        for(int i=0;i<5;i++){
            System.out.println(new StaticBlockTest());
        }
    }
}

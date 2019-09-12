package JavaBasic;

import java.awt.image.VolatileImage;

/**
 * @Classname JavaAssembly
 * @Description TODO
 * @Date 19-6-1 下午8:46
 * @Created by mao<tianmao818@qq.com>
 */
public class JavaAssembly {
    private volatile int a;
    private volatile int b;
    private volatile int c;
    JavaAssembly(int a,int b,int c){
        this.a=a;
        this.b=b;
        this.c=c;
    }
    public static void main(String[] args){
        JavaAssembly javaAssembly=new JavaAssembly(1,2,3);
        int a=0;
        int b=1;
        System.out.println(a+b);
    }
}

package CommonProblems.mathdemo;

/**
 * @Author MaoTian
 * @Classname MaxGCB
 * @Description 最大公约数
 * @Date 下午7:05 2019/8/14
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class MaxGCB {
    public int gcb(int a,int b){
        if(b==0){
            return a;
        }
        //a%b==0---->b
        return gcb(b,a%b);
    }
    public static void main(String[] args) {
        MaxGCB maxGCB=new MaxGCB();
        System.out.println(maxGCB.gcb(24,12));
    }
}

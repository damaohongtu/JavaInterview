package CommonProblems.mathdemo;

/**
 * @Author MaoTian
 * @Classname 幂次方
 * @Description TODO
 * @Date 下午9:26 2019/8/14
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class AB {
    public int calculate(int a,int b){
        if(b==0){
            return 1;
        }
        if(b%2==1){
            return calculate(a,b/2)*calculate(a,b/2)*a;
        }else{
            return calculate(a,b/2)*calculate(a,b/2);
        }
    }



    public static void main(String[] args) {
        int a=2,b=3;
        AB ab=new AB();
        System.out.println(ab.calculate(a,b));
    }
}

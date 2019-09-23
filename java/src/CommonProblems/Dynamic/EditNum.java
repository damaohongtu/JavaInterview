package CommonProblems.Dynamic;

/**
 * @Author MaoTian
 * @Classname EditNum
 * @Description TODO
 * @Date 下午4:05 2019/9/17
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class EditNum {

    public int helper(int a,int b){
        if(a==b){
            return 0;
        }else {
            StringBuilder sb=new StringBuilder(String.valueOf(a));
            String s=sb.reverse().toString();
            int tmp=Integer.parseInt(s);
            if(tmp==b){
                return 1;
            }

            int c=Math.abs(a-b);
            int d=Math.abs(tmp-b);

            if(c>d){
                a=tmp;
            }
            int e=a>b?helper(a-1,b):helper(a+1,b);
            return e+1;
        }
    }

    public static void main(String[] args) {
        int a=36925814;
        int b=96925814;
        EditNum e=new EditNum();
        System.out.println(e.helper(a,b));
    }
}

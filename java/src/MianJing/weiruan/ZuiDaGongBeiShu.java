package MianJing.weiruan;/**
 * @Classname ZuiDaGongBeiShu
 * @Description 求两个数的最大公约数:辗转相除法
 * @Date 19-6-8 下午8:42
 * @Created by mao<tianmao818@qq.com>
 */
public class ZuiDaGongBeiShu {
    public int helper(int a,int b){
        int r=0;
        while(b>0){
            r=a%b;
            a=b;
            b=r;
        }
        return a;
    }
    public static void main(String[] args){
        ZuiDaGongBeiShu z=new ZuiDaGongBeiShu();
        System.out.println(z.helper(12,6));
    }
}

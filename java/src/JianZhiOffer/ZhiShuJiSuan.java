package JianZhiOffer;/**
 * @Classname Z
 * @Description 指数计算，使用折半的方法
 * @Date 19-7-21 下午5:26
 * @Created by mao<tianmao818@qq.com>
 */
public class ZhiShuJiSuan {
    public static double exp(double b,int e){
        double res=0;
        if (e==0){
            return 1;
        }
        if(e==1){
            return b;
        }
        int flag=0;
        if(e<0){
            e=0-e;
            flag=1;
        }

        if(e%2==1){
            res=exp(b,e/2)*exp(b,e/2)*b;
        }else{
            res=exp(b,e/2)*exp(b,e/2);
        }
        if(flag==0){
            return res;
        }else{
            return 1.0/res;
        }
    }
    public static void main(String[] args){
        System.out.println(exp(4.0,2));
    }
}

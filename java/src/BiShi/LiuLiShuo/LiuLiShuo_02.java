package BiShi.LiuLiShuo;

import java.io.File;
import java.util.Scanner;

/**
 * @Author MaoTian
 * @Classname LiuLiShuo_02
 * @Description TODO
 * @Date 下午6:21 2019/8/19
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class LiuLiShuo_02 {
    public static void main(String[] args)throws Exception {
        Scanner sc =new Scanner(new File("/home/mao/workspace/java/src/BiShi/LiuLiShuo/test2"));
        //Scanner sc =new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            if(n==0){
                System.out.println(0);
            }else if(n==1||n==2){
                System.out.println(n);
            }else{
                int[] dp=new int[n+1];
                dp[0]=0;
                dp[1]=1;
                dp[2]=2;
                for(int i=3;i<=n;i++){
                    dp[i]=dp[i-1]+dp[i-2];
                }
                System.out.println(dp[n]);
            }

        }
    }
}

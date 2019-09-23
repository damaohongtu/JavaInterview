package ByteDancePreparation;

import java.io.File;
import java.util.Scanner;

public class Main_3 {
    public static void main(String[] args)throws Exception {
        Scanner sc =new Scanner(new File("/home/mao/workspace/面试/JavaGuide/JavaInterview/java/src/ByteDancePreparation/main_3"));
        //Scanner sc =new Scanner(System.in);
        while(sc.hasNext()){

            int n=sc.nextInt();
            int[] d=new int[n];

            //保存数值
            for (int i = 0; i <n ; i++) {
                d[i]=sc.nextInt();
            }

            //dp[i][j]表示从数组的i---j这一段的结果，则最终结果就是从1---n这一段的结果
            int[][] dp=new int[n+1][n+1];

            for(int i=1;i<=n;i++){
                dp[i][i]=d[i-1];
            }

            for(int e=1;e<=n;e++){
                for(int s=e-1;s>=1;s--){
                    if(e-s==1){
                        //从头取值还是从尾取值
                        dp[s][e]=Math.max(d[s-1],d[e-1]);
                    }else{
                        //      (s-1)---(s)---(s+1)---(s+2)---(e-1)---(e)
                        //另外一个人足够聪明，会取最大的值
                        dp[s][e]=Math.max(d[s-1]+Math.min(dp[s+2][e],dp[s+1][e-1]),
                                d[e-1]+Math.min(dp[s][e-2],dp[s+1][e-1]));
                    }
                }
            }
            System.out.println(dp[1][n]);
        }
    }
}

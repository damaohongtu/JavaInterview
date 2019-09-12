package BiShi.BZ;

import java.io.File;
import java.util.Scanner;

/**
 * @Author MaoTian
 * @Classname BZ_1
 * @Description TODO
 * @Date 下午6:23 2019/9/10
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class BZ_1 {

    public static int getMin(String s1,String s2){

        int n1=s1.length();
        int n2=s2.length();
        int[][] dp=new int[1000][1000];
        for (int i = 0; i <=n1 ; i++) {
            dp[i][0]=i;
        }
        for (int i = 0; i <=n2 ; i++) {
            dp[0][i]=i;
        }

        for (int i = 1; i <=n1 ; i++) {
            for (int j = 1; j <=n2 ; j++) {
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else {
                    dp[i][j]=Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]))+1;
                }
            }
        }

        return dp[n1][n2];
    }

    public static void main(String[] args)throws Exception {
        Scanner sc =new Scanner(new File("/home/mao/workspace/java/src/BiShi/BZ/test1"));
        //Scanner sc =new Scanner(System.in);
        while(sc.hasNext()){
            String s1=sc.next();
            String s2=sc.next();
            System.out.println(getMin(s1,s2));
        }
    }
}

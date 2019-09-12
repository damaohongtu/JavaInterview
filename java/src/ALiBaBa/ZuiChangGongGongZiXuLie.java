package ALiBaBa;

import org.junit.Test;

/**
 * @Author MaoTian
 * @Classname ZuiChangGongGongZiXuLie
 * @Description
 *
 * dp[i][j]=dp[i-1][j-1]+1  or Math.max(dp[i-1][j],dp[i][j-1])
 *
 *
 * @Date 上午9:36 2019/8/17
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class ZuiChangGongGongZiXuLie {
    public int getMaxCommon(String s1,String s2){
        char[] arr1=s1.toCharArray();
        int m=arr1.length+1;
        char[] arr2=s2.toCharArray();
        int n=arr2.length+1;

        int[][] dp=new int[m][n];
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(arr1[i-1]==arr2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
//                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                    dp[i][j]=0;
                }
            }
        }
        int res=0;
        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if(res<dp[i][j]){
                    res=dp[i][j];
                }
            }
        }

        return res;
    }
    @Test
    public void check(){
        String s1="56126b4000";
        String s2="23b490000000";
        int res=getMaxCommon(s1,s2);
        System.out.println(res);
    }
}

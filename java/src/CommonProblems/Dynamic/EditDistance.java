package CommonProblems.Dynamic;

/**
 * @Author MaoTian
 * @Classname EditDistance
 * @Description TODO
 * @Date 下午3:40 2019/9/17
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class EditDistance {
    public int helper(String s1,String s2){

        int m=s1.length();
        int n=s2.length();

        //dp[i][j]表示长度为i的s1的子串转换为长度为j的s2的子串的操作次数
        int[][] dp=new int[m+1][n+1];
        for (int i = 0; i <=m ; i++) {
            dp[i][0]=i;//删除
        }
        for (int i = 0; i <=n ; i++) {
            dp[0][i]=i;//插入
        }

        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){

                int replaces=0;
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    replaces=dp[i-1][j-1];
                }else {
                    replaces=dp[i-1][j-1]+1;
                }
                dp[i][j]=Math.min(replaces,//替换
                        Math.min(dp[i-1][j],//插入
                                dp[i][j-1]+1)//删除
                );
            }
        }

        return dp[m][n];
    }
}

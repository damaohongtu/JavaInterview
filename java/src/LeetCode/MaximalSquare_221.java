package LeetCode;/**
 * @Classname MaximalSquare_221
 * @Description Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 * Input:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * Output: 4   返回的是正方形
 * @Date 19-5-21 下午3:20
 * @Created by mao<tianmao818@qq.com>
 */
public class MaximalSquare_221 {
    public int maximalSquare(char[][] matrix) {
        int M=matrix.length;
        if(M==0){
            return 0;
        }
        int N=matrix[0].length;
        int K=Math.min(M,N);
        int result=0;

        for (int k=1;k<K;k++){
            for(int i=0;i<M-k;i++){
                for(int j=0;j<N-k;j++){
                    if(helper(matrix,i,j,k)){
                        result=k;
                    }
                }
            }
        }
        return result*result;
    }
    public boolean helper(char[][] matrix,int i,int j,int k){

        for(int m=i;m<i+k;m++){
            for(int n=j;n<j+k;n++){
                if(matrix[m][n]=='0'){
                    return false;
                }
            }
        }
        return true;
    }

    //使用动态规划
    public int maximalSquare_DP(char[][] matrix) {
        if (matrix.length == 0)
            return 0;
        // dp[i][j]意为：以matrix[i - 1][j - 1]为某一正方形的右下角端点时可以得到的最大正方形边长
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        // max记录最大正方形的边长
        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max * max;
    }


}

package ALiBaBa;


public class AliBaBa {

    public static int findPath(int n, int[][] area){
        int k = 0;
        if(n % 2 == 0)
            k = n + 1;
        else
            k = n;
        int[][] dp=new int[k][n];
        for(int i=1; i < k; ++i){
            for(int j=0; j < n; ++j){
                if(i == 1){
                    dp[i][j] = area[i][j];
                }else{
                    if(j <= 1 || i == k-1)
                        dp[i][j] = dp[i-2][j] + area[i-1][j];
                    else
                        dp[i][j] = Math.min(dp[i-2][j] + area[i-1][j], dp[i][j-2] + area[i][j-1]);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int j=0; j < n; ++j)
            ans = Math.min(ans, dp[k-1][j]);
        return ans;
    }

    public static void main(String[] args) {
        int N = 6;
        int[][] inter = {{1,2,3,5,7,6},
                {2,1,4,5,7,4},
                {3,4,5,6,3,6},
                {2,3,1,4,6,8},
                {5,6,2,4,6,2},
                {4,2,4,1,1,6}
        };
        int ans = findPath(N,inter);
        System.out.println(ans);
    }

}

package LeetCode;/**
 * @Classname BestTimeToBuyAndSellStockWithCooldown_309
 * @Description
 * Input: [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 * 注意:买了需要休息一天...,然后才能交易!
 * @Date 19-5-21 上午11:22
 * @Created by mao<tianmao818@qq.com>
 */
public class BestTimeToBuyAndSellStockWithCooldown_309 {

    public int maxProfit(int[] prices) {
        int n=prices.length;
        if(n==0){
            return 0;
        }
        int[][] ans=new int[n][3];
        //休息  当前的利润
        ans[0][0]=0;
        //买入  当前的利润
        ans[0][1]=-prices[0];
        int bought=ans[0][1];
        //卖出  当前的利润
        ans[0][2]=Integer.MIN_VALUE;

        for(int i=1;i<n;i++){
            ans[i][0]=max(ans[i-1][0],ans[i-1][1],ans[i-1][2]);
            ans[i][1]=ans[i-1][0]-prices[i];
            ans[i][2]=bought+prices[i];


            bought=Math.max(bought,ans[i][1]);
        }
        int result=ans[0][0];
        return max(ans[n-1][0],ans[n-1][1],ans[n-1][2]);
    }
    public int max(int a,int b,int c){

        return a>b?a:(b>c?b:c);
    }
}

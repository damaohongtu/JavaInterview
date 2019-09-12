package LeetCode;/**
 * @Classname TargetSum_494
 * @Description 数组,通过添加正负号来判断是否和target相等
 * @Date 19-5-23 上午11:23
 * @Created by mao<tianmao818@qq.com>
 */
public class TargetSum_494{
    int ans=0;
    public int findTargetSumWays(int[] nums, int S) {
        helper(nums,S,nums.length,0);
        return ans;
    }
    public void helper(int[] nums, int S, int n, int startIndex){

        if(startIndex==n){
            if(S==0){
                ans++;
            }
            return;
        }
        helper(nums,S-nums[startIndex],n,startIndex+1);
        helper(nums,S+nums[startIndex],n,startIndex+1);
    }
}

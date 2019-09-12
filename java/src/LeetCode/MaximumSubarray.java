package LeetCode;

import java.util.Arrays;

/**
 * @Classname MaximumSubarray
 * @Description TODO
 * @Date 19-2-28 上午10:24
 * @Created by mao<tianmao818@qq.com>
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int len=nums.length;
        int sum[]=new int[len];
        sum[0]=nums[0];
        for(int i=1;i<len;i++){
            sum[i]=max(nums[i],nums[i]+sum[i-1]);
        }
        return Arrays.stream(sum).max().getAsInt();
    }
    public int max(int a,int b){
        return a>b? a:b;
    }
}
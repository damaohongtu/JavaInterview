package LeetCode;

import java.util.Arrays;

/**
 * @Classname LongestIncreasingSubsequence_300
 * @Description TODO
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * @Date 19-5-21 上午10:42
 * @Created by mao<tianmao818@qq.com>
 */
public class LongestIncreasingSubsequence_300 {
    public int lengthOfLIS(int[] nums) {

        int len=nums.length;

        if(len==0){
            return 0;
        }

        int[] a =new int[len];

        for (int i=0;i<len;i++){
            a[i]=1;
        }

        for(int i=1;i<len;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    a[i]=(a[i]>a[j]+1?a[i]:a[j]+1);
                }
            }
        }

        Arrays.sort(a);

        return a[len-1];
    }
}

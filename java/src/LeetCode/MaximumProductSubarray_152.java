package LeetCode;

import java.util.Arrays;

/**
 * @Classname MaximumProductSubarray_152
 * @Description TODO
 * @Date 19-5-7 下午10:16
 * @Created by mao<tianmao818@qq.com>
 */
public class MaximumProductSubarray_152 {
    public static int maxProduct(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int max=nums[0],min=nums[0],result=nums[0];
        for(int i=1;i<nums.length;i++){
            int temp=max;
            max=Math.max(nums[i],Math.max(nums[i]*min,nums[i]*max));
            min=Math.min(nums[i],Math.min(nums[i]*temp,nums[i]*min));
            result=Math.max(result,max);
        }
        return result;
    }
    public static void main(String[] args){
        int[] test1={2,3,-4};
        int[] test2={2,3,-4,-5};
        System.out.println(maxProduct(test1));
        System.out.println(maxProduct(test2));
    }
}

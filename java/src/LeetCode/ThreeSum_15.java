package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname ThreeSum_15
 * @Description TODO
 * @Date 19-5-22 上午8:35
 * @Created by mao<tianmao818@qq.com>
 */
public class ThreeSum_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        if(nums.length==0){
            return new ArrayList<>();
        }
        return kSum(nums,3,0,0);
    }
    public List<List<Integer>> kSum(int[] nums, int k, int target,int startIndex){
        List<List<Integer>> res=new ArrayList<>();

        if(nums.length-startIndex<k){
            return res;
        }
        if(k==2){
            int i=startIndex;
            int j=nums.length;
            while(i<j){
                if(nums[i]+nums[j]==target){
                    List<Integer> temp=new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    while(i<j && nums[i]==nums[++i]);
                    while(i<j && nums[j]==nums[--j]);
                    res.add(temp);
                }else if(nums[i]+nums[j]<target){
                    i++;
                }else{
                    j--;
                }
            }
            return res;
        }else{
            for(int i=startIndex;i<nums.length;i++){
                if(i>startIndex && nums[i]==nums[i-1]){
                    continue;
                }

                List<List<Integer>>tempList=kSum(nums,k-1,target-nums[i],i+1);

                for(List<Integer> temp:tempList){
                    //每一次的添加nums[i]
                    temp.add(0,nums[i]);
                    //添加到最终的结果中去
                    res.add(temp);
                }
            }
        }
        return res;
    }
}

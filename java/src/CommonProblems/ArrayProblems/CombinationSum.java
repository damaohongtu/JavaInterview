package CommonProblems.ArrayProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author MaoTian
 * @Classname CombinationSum
 * @Description 求解所有和为target的子序列
 * @Date 下午4:41 2019/8/15
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        
        List<List<Integer>>result=new ArrayList<>();
        Arrays.sort(nums);
        
        helper(nums,target,0,new ArrayList<Integer>(),result);
        
        return result;
    }
    private void helper(int[] nums,int target,int start,List<Integer>sumList,List<List<Integer>>result){
        if(target==0){
            result.add(new ArrayList<>(sumList));
        }
        if(target<0||nums[start]>target){
            return;
        }
        for(int i=start;i<nums.length;i++){
            sumList.add(nums[i]);
            helper(nums,target-nums[i],i,sumList,result);
            sumList.remove(sumList.size()-1);
        }
    }
}

package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//使用HashMap进行计数
public class PermutationsII {
    private List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums){
        HashMap<Integer,Integer>count=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(count.containsKey(nums[i])){
                count.put(nums[i],count.get(nums[i])+1);
            }else{
                count.put(nums[i],1);
            }
        }
        helper(nums,new ArrayList<>(),count);
        return res;
    }
    public void helper(int[] nums,List<Integer> list,HashMap<Integer,Integer> count){
        if(list.size()==nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        for(Integer i:count.keySet()){
            if(count.get(i)>0){
                list.add(i);
                count.put(i,count.get(i)-1);
                helper(nums,list,count);
                count.put(i, count.get(i) + 1);
                list.remove(list.size()-1);
            }
        }
    }

}

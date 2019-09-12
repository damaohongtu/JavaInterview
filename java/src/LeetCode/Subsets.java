package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Subsets {
    private List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        helper(nums,new ArrayList<>(),0);
        HashSet h=new HashSet(res);
        res.clear();
        res.addAll(h);
        return res;
    }
    public void helper(int[]nums,List<Integer>list,int start){
        res.add(new ArrayList<Integer>(list));
        for (int i = start; i < nums.length; i++) {
//            if (list.contains(nums[i])) {
//                continue;
//            }
            list.add(nums[i]);
            helper(nums, list,i+1);
            list.remove(list.size() - 1);
        }

    }
    public static void main(String[]args){
        int nums[]={1,2,2};
        Subsets s=new Subsets();
        List<List<Integer>> result=new ArrayList<>();
        result=s.subsets(nums);
        System.out.println(result);
    }

}

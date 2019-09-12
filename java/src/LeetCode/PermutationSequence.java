package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    public String getPermutation(int n, int k) {
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=i+1;
        }
        List<List<Integer>> lists=permute(nums);
        String result="";
        for(int i:lists.get(k-1)){
            result+=i;
        }
        return result;
    }
    List<List<Integer>> lists;
    public List<List<Integer>> permute(int[] nums) {
        lists = new ArrayList<List<Integer>>();
        helper(nums, 0, nums.length, new ArrayList<Integer>());
        return lists;
    }
    private void helper(int[] nums, int start, int length, List<Integer> list) {
        if (list.size() == length) {
            lists.add(new ArrayList<Integer>(list));
            return;
        }

        if (start >= length) {
            return;
        }

        for (int i = 0; i < length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            // Choose
            list.add(nums[i]);

            // Explore
            helper(nums, i, length, new ArrayList<Integer>(list));

            // UnChoose
            list.remove(list.size() - 1);
        }
    }
}

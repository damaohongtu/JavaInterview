package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    List<List<Integer>> lists;
    int count=0;
    public List<List<Integer>> permute(int[] nums,int k) {
        lists = new ArrayList<List<Integer>>();
        helper(nums, 0, nums.length, new ArrayList<Integer>(),k);
        return lists;
    }
    private void helper(int[] nums, int start, int length, List<Integer> list,int k) {
        if (list.size() == length) {
            lists.add(new ArrayList<Integer>(list));
            count++;
            return;
        }

        if (start >= length || count>k) {
            return;
        }

        for (int i = 0; i < length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            // Choose
            list.add(nums[i]);

            // Explore
            helper(nums, i, length, new ArrayList<Integer>(list),k);

            // UnChoose
            list.remove(list.size() - 1);
        }
    }
    public static void main(String[]args){
        Permutations permutations=new Permutations();
        int[] nums={1,2,3,4};
        System.out.println(permutations.permute(nums,3));
    }
}

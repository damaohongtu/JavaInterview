package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CombinationSum {
    private List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] condiantes,int target){
        Arrays.sort(condiantes);
        combinationSumHelper(condiantes,target,0,new ArrayList<Integer>());
        HashSet h=new HashSet(result);
        result.clear();
        result.addAll(h);
        return result;
    }
    private void combinationSumHelper(int[] condinates,int target,int start,List<Integer>sumList){
        if (target==0){
            result.add(new ArrayList<>(sumList));
        }
        if(target<0||start>condinates.length-1||target<condinates[start]){
            return;
        }
        for(int i=start;i<condinates.length;i++){
            sumList.add(condinates[i]);
            System.out.println("***"+sumList+"***");
            combinationSumHelper(condinates,target-condinates[i],i+1,sumList);
            System.out.println("---"+sumList+"---");
            sumList.remove(sumList.size()-1);
        }
    }
    public static void main(String[] args){
        int[] condinates={10,1,2,7,6,1,5};
        int target=8;
        CombinationSum combinationSum=new CombinationSum();
        System.out.println(combinationSum.combinationSum(condinates,target));
    }
}

package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class KSum {
    public static List<List<Integer>> fourSum(int[]nums,int target){

        List<List<Integer>> res=new LinkedList<>();


        if (nums==null||nums.length==0){
            return res;
        }
        Arrays.sort(nums);
        res=kSum(4,nums,0,target);
        return res;
    }


    public static  List<List<Integer>> kSum(int k,int[] nums,int startIndex,int target){

        //保存结果
        List<List<Integer>> res=new LinkedList<>();

        //不能够再进行增加了
        if(k>nums.length-startIndex){
            return res;
        }
        if(k==2){
            int i=startIndex,j=nums.length-1;
            while(i<j){
                if(nums[i]+nums[j]==target){

                    List<Integer> temp=new LinkedList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    res.add(temp);

                    while(i<j&&nums[i]==nums[++i]);
                    while(i<j&&nums[j]==nums[--j]);

                }else if(nums[i]+nums[j]<target){
                    i++;
                }else {
                    j--;
                }
            }
            return res;
        }else{
            //startIndex避免重复,去掉当前的数值
            for(int i=startIndex;i<nums.length;i++){

                //避免重复
                if(i>startIndex && nums[i]==nums[i-1]){
                    continue;
                }

                List<List<Integer>>tempList=kSum(k-1,nums,i+1,target-nums[i]);

                for(List<Integer> temp:tempList){
                    //每一次的添加nums[i]
                    temp.add(0,nums[i]);
                    //添加到最终的结果中去
                    res.add(temp);
                }
            }
            return res;
        }
    }
    public static void main(String[] args){
        int[] nums={1,0,-1,0,-2,2};
        int target=0;
        List<List<Integer>> res=fourSum(nums,target);
        System.out.println(res);
    }
}

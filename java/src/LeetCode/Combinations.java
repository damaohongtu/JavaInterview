package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    private static List<List<Integer>> res=new ArrayList<>();
    public static List<List<Integer>>combine(int n,int k){
        helper(n,1,k,new ArrayList<>());
        return res;
    }
    public static void helper(int n,int start,int k,List<Integer>sumList){
        if (k==0){
            res.add(new ArrayList<>(sumList));
        }
        //注意这里的长度:终点-起点+1
        if(k<0||n-start+1<k){
            return;
        }
        for(int i=start;i<n+1;i++){
            sumList.add(i);
            System.out.println("***"+sumList+"***");
            helper(n,i+1,k-1,sumList);
            System.out.println("---"+sumList+"---");
            sumList.remove(sumList.size()-1);
        }
    }
    public static void main(String[] args){
        int n=4;
        int k=2;
//        combine(4,2);
        List<List<Integer>> result=combine(4,3);
        System.out.println(result);
    }
}

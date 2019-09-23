package NiuKeWang.WangNianZhenTI;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @Classname Shopee_02
 * @Description 这到题目和确定分割出来的ip数目是一样的,使用dfs方式来遍历所有的情况
 * @Date 19-7-11 下午3:29
 * @Created by mao<tianmao818@qq.com>
 */

class Solution{
    //存结果
    private ArrayList<ArrayList<Integer>>res=new ArrayList<>();

    public ArrayList<ArrayList<Integer>> getRes(ArrayList<Integer> nums,int m){
        ArrayList<Integer> list=new ArrayList<>();
        dfs(nums,list,0,0,m);
        return res;
    }

    //dfs
    //cur 当前
    //num 当前时间段
    public void dfs(ArrayList<Integer> nums,ArrayList<Integer> list,int cur,int num,int m){
        if(num==m&&cur==nums.size()){
            System.out.println("-----------------------------------");
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=cur;i<nums.size();i++){
            List<Integer> tmp=nums.subList(cur,i+1);
            list.add(sum(tmp));
            System.out.println(list);
            dfs(nums,list,i+1,num+1,m);
            //dfs执行完,已经将结果存入
            list.remove(list.size()-1);
        }

    }

    //求和
    public int sum(List<Integer> nums){
        int res=0;
        for(Integer i:nums){
            res+=i;
        }
        return res;
    }
}
public class Shopee_02 {

    public static void main(String[] args)throws IOException {
//        Scanner sc=new Scanner(System.in);
        Scanner sc=new Scanner(new File("/home/mao/workspace/java/src/WangNianZhenTI/Shoppe_02"));
        while (sc.hasNext()){
            int n=sc.nextInt();
            int m=sc.nextInt();
            ArrayList<Integer>nums=new ArrayList<>();
            for(int i=0;i<n;i++){
                nums.add(sc.nextInt());
            }
            Solution solution=new Solution();
            ArrayList<ArrayList<Integer>> res=solution.getRes(nums,m);
            ArrayList<Integer> ans=new ArrayList<>();
            for(ArrayList<Integer> r:res){
                int tmp= Collections.max(r);
                ans.add(tmp);
            }
            System.out.println(Collections.min(ans));
        }
    }
}

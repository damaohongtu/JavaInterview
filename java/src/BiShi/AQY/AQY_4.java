package BiShi.AQY;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class AQY_4 {

    //输入三个数组，一个数字m
    //返回m长的三元组
    public ArrayList<ArrayList<Integer>> getTupple(int[] nums1,int[] nums2,int[] nums3,int m){
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();

        PriorityQueue<Integer>heap1=new PriorityQueue<>(m,(a,b)->(b-a));
        PriorityQueue<Integer>heap2=new PriorityQueue<>(m,(a,b)->(b-a));
        PriorityQueue<Integer>heap3=new PriorityQueue<>(m,(a,b)->(b-a));

        int n=nums1.length;
        for (int i = 0; i <n ; i++) {
            heap1.add(nums1[i]);
            heap2.add(nums2[i]);
            heap3.add(nums3[i]);
        }

        for (int j = 0; j < m; j++) {
            ArrayList<Integer>tmp=new ArrayList<>();
            int num1=heap1.poll();
            tmp.add(num1);
            int num2=heap2.poll();
            tmp.add(num2);
            int num3=heap3.poll();
            tmp.add(num3);

            res.add(tmp);
        }
        return res;
    }
}

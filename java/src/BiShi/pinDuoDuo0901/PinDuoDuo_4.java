package BiShi.pinDuoDuo0901;

import CommonProblems.AB;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class PinDuoDuo_4 {

    public static void main(String[] args)throws Exception {
        Scanner sc=new Scanner(new File("/home/mao/workspace/java/src/BiShi/pinDuoDuo0901/test4"));
//        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int m=sc.nextInt();
            int k=sc.nextInt();
            ArrayList<Integer> nums=new ArrayList<>();
            int start=(int)Math.sqrt(k);
            int count=k*k;
            for(int i=n;i>=1&&count>=0;i--){
                for(int j=m;j>=1&&count>=0;j--){
                    nums.add(i*j);
                    count--;
                }
            }
            Collections.sort(nums, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            });
            System.out.println(nums.get(k-1));
        }
    }
}

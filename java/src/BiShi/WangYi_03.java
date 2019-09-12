package BiShi;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Scanner;

public class WangYi_03 {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(new File("/home/mao/workspace/java/src/BiShi/wangyi_01"));

        while(sc.hasNext()){
            int n=sc.nextInt();
            int[] students=new int[n];
            int[] nums=new int[151];

            for(int i=0;i<n;i++){
                int tmp=sc.nextInt();
                students[i]=tmp;
                nums[tmp]++;
            }


            int person=sc.nextInt();
            for(int j=0;j<person;j++){
                int q=sc.nextInt();
                int core=students[q-1];
                int low=0;

                for(int i=0;i<=core;i++){
                    low+=nums[i];
                }

                double rank=(low-1)/(n+0.0)*100;
                String s=new DecimalFormat("#.000000").format(rank);
                if (s.equals(".000000")){
                    System.out.println("0.000000");
                }else{
                    System.out.println(s);
                }

            }
        }
    }
}

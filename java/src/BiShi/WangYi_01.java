package BiShi;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WangYi_01 {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(new File("/home/mao/workspace/java/src/BiShi/wangyi_01"));
        while(sc.hasNext()){
            int n=sc.nextInt();
            int[] students=new int[n];
            List<Integer> cores=new ArrayList<>();
            for(int i=0;i<n;i++){
                int tmp=sc.nextInt();
                students[i]=tmp;
                cores.add(tmp);
            }

            Collections.sort(cores);

            int person=sc.nextInt();
            for(int j=0;j<person;j++){
                int q=sc.nextInt();
                int core=students[q-1];
                int low=cores.lastIndexOf(core);
                double rank=low/(n+0.0)*100;
                String s=new DecimalFormat("#.000000").format(rank);
                if (s.equals(".000000")){
                    System.out.println("0.000000");
                }else{
                    System.out.println(s);
                }

            }
        }
        System.out.println("-------------------------------");
        double num = .000;
        String result = String.format("%.9f", num);
        System.out.println(result);
    }
}

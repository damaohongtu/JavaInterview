package BiShi;

import java.io.File;
import java.util.Scanner;

public class WangYi_04 {
    public static void main(String[] args)throws Exception {
        Scanner sc=new Scanner(new File("/home/mao/workspace/java/src/BiShi/wangyi_01"));
        while (sc.hasNext()){
            int n=sc.nextInt();
            int q=sc.nextInt();
            int[] nums=new int[n];

            for(int i=0;i<n;i++){
                nums[i]=sc.nextInt();
            }

            for(int j=0;j<q;j++){
                int s=sc.nextInt();
                int count=0;

                for(int k=0;k<n;k++){
                    if(nums[k]>=s){
                        count++;
                        nums[k]=nums[k]-1;
                    }
                }
                System.out.println(count);
            }
        }
    }
}

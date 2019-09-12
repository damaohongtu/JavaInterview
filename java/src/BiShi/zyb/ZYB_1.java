package BiShi.zyb;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author MaoTian
 * @Classname XieCheng_01
 * @Description TODO
 * @Date 下午6:51 2019/9/4
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class ZYB_1 {

    public static int getMaxLength(long[] nums){
        int n=nums.length;
        int res=0;
        int[] tmp=new int[n];

        for(int i=2;i<n;i++){
            int j=i;
            long a=nums[i-2];
            long b=nums[i-1];

            int count=0;
            while(j<n && Arrays.binarySearch(nums,j,n,(a+b))>-1){
                j=Arrays.binarySearch(nums,j,n,(a+b));
                long c=a+b;
                a=b;
                b=c;
                count++;
            }
            tmp[i]=count;
        }
        for(int i=0;i<n;i++){
            if(tmp[i]>res){
                res=tmp[i];
            }
        }
        return res+2;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc=new Scanner(new File("/home/mao/workspace/java/src/BiShi/zyb/test1"));
        //Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String s=sc.nextLine();
            String[] nums1=s.split(" ");
            long[] nums=new long[nums1.length];
            for(int i=0;i<nums.length;i++){
                nums[i]=Integer.parseInt(nums1[i]);
            }
            int res=getMaxLength(nums);
            if(res==2){
                res=0;
            }
            System.out.println(res);
        }
    }
}

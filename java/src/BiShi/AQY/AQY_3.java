package BiShi.AQY;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AQY_3 {


    public static long permutation(int N,int[] nums){
        long[] list=new long[1];

        int[] arr=new int[N];
        for(int i=1;i<=N;i++){
            arr[i-1]=i;
        }

        helper(arr,0,list,nums);
        return list[0];
    }
    public static boolean check(int[] arr,int[] nums){
        for (int i = 0; i <nums.length ; i++) {
            if((nums[i]==1)&&arr[i]<arr[i+1]){
                return false;
            }
            if((nums[i]==0)&&arr[i]>arr[i+1]){
                return false;
            }
        }
        return true;
    }
    public static void helper(int[] arr,int start,long[] list,int[] nums) {
        if((start==arr.length-1)&&check(arr,nums)){
            list[0]=list[0]+1;
            list[0]=list[0]%(1000000000+7);
        }else{

            for(int i=start;i<arr.length;i++){
                int tmp=arr[start];
                arr[start]=arr[i];
                arr[i]=tmp;
                helper(arr,start+1,list,nums);
                arr[i]=arr[start];
                arr[start]=tmp;
            }
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc=new Scanner(new File("/home/mao/workspace/java/src/BiShi/AQY/test1"));
        //Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int N=sc.nextInt();
            int[] nums=new int[N-1];

            for (int i = 0; i <N-1 ; i++) {
                nums[i]=sc.nextInt();
            }

            long p=permutation(N,nums);
            System.out.println(p);
        }
    }
}

package BiShi.ByteDance;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author MaoTian
 * @Classname Main_1
 * @Description TODO
 * @Date 下午4:53 2019/9/14
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class Main_1 {
    public static int check(int a,int b,int c){
        if((b-a)<=10 && (c-b)<=10){
            return 0;
        }else if((b-a)>10 && (b-a)<=20 || (b-a)<=10 && (c-b)>10){
            return 1;
        }else {
            return 2;
        }

    }
    public static void main(String[] args)throws Exception {
        Scanner sc =new Scanner(new File("/home/mao/workspace/面试/JavaGuide/JavaInterview/java/src/BiShi/ByteDance/main_1"));
        //Scanner sc =new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int[] nums=new int[n];
            for (int i=0;i<n;i++){
                nums[i]=sc.nextInt();
            }
            Arrays.sort(nums);
            int count=0;
            int post=0;
            for (int i = 0; i <n-2 ; ) {
                int a=nums[i];
                int b=nums[i+1];
                int c=nums[i+2];
                int tmp=check(a,b,c);

                if(tmp==0){
                    i=i+3;
                }else if(tmp==1){
                    count++;
                    i=i+2;
                }else{
                    count+=2;
                    i=i+1;
                }
                post=i;
            }
            if(post==n-2){
                int a=nums[n-2];
                int b=nums[n-1];
                if((b-a)<=20){
                    count++;
                }else{
                    count+=4;
                }
            }
            System.out.println(count);
        }
    }
}

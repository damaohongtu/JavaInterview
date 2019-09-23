package ByteDancePreparation;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author MaoTian
 * @Classname Main_1
 * @Description TODO
 * 6
 * -2 0 1 2 3 6
 * 2
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class Main_1 {

    public static void main(String[] args)throws Exception {
        Scanner sc =new Scanner(new File("/home/mao/workspace/面试/JavaGuide/JavaInterview/java/src/ByteDancePreparation/main_1"));
        //Scanner sc =new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int[] nums=new int[n];
            for (int i = 0; i <n ; i++) {
                nums[i]=sc.nextInt();
            }
            int target=sc.nextInt();
            int res=0;
            for (int i=0;i<n-2;i++){
                for (int j=i+1;j<n-1;j++){
                    for (int k = j+1; k <n ; k++) {
                        if(nums[i]+nums[j]+nums[k]<target){
                            res++;
                        }
                    }
                }
            }
            System.out.println(res);
        }
    }
}

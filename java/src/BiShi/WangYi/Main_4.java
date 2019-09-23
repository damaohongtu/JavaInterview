package BiShi.WangYi;

import java.io.File;
import java.util.Scanner;

/**
 * @Author MaoTian
 * @Classname Main_4
 * @Description TODO
 * @Date 下午3:04 2019/9/21
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class Main_4 {


    public static int getDistance(int[] nums){
        int count=0;
        int n=nums.length;
        for (int i = 0; i <n ; i++) {
            for (int j = i+1; j <n ; j++) {
                if(nums[j]<nums[i]){
                    count+=(j-i);
                }
            }
        }

        return count;
    }

    public static void main(String[] args)throws Exception {
        Scanner sc =new Scanner(new File("/home/mao/workspace/专业/JavaGuide/JavaInterview/java/src/BiShi/WangYi/main_4"));
        //Scanner sc =new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int[] nums=new int[n];
            for (int i = 0; i <n ; i++) {
                nums[i]=sc.nextInt();
            }

            System.out.println(getDistance(nums));
        }
    }
}

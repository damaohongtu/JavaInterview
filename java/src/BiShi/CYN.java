package BiShi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author MaoTian
 * @Classname CYN
 * @Description TODO
 * @Date 下午4:29 2019/9/6
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */

interface Test1{
    public void test1();
}
interface Test2 extends Test1{

}

public class CYN {
    public static int getDays(int[] nums,int k){
        int count=0;
        int i=0;
        for(;i<nums.length;i++){
            count+=nums[i];
            if(count>=k){
                break;
            }
        }
        if(count>=k){
            return i;
        }else {
            return -1;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {

        ThreadPoolExecutor s;

        Executors.newFixedThreadPool(9);
        Executors.newCachedThreadPool();
        Executors.newSingleThreadExecutor();


//        Scanner sc=new Scanner(System.in);
        Scanner sc=new Scanner(new File("/home/mao/workspace/java/src/BiShi/test"));
        while (sc.hasNext()){
            int n=sc.nextInt();
            int k=sc.nextInt();

            ArrayList<Integer> tmp=new ArrayList<>();
            for (int i = 0; i <n ; i++) {

                int v=sc.nextInt();
                while (v>8){
                    tmp.add(8);
                    v=v-8;
                }
                tmp.add(v);
            }
            int[] nums=new int[tmp.size()];
            for (int i = 0; i <tmp.size() ; i++) {
                nums[i]=tmp.get(i);
            }
            System.out.println(getDays(nums,k));
        }
    }
}

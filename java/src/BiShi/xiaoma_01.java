package BiShi;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Classname xiaoma_01
 * @Description 交换数组中相邻数字的值,使得最后输出的数字最大
 * @Date 19-4-25 下午8:10
 * @Created by mao<tianmao818@qq.com>
 */
public class xiaoma_01 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("/home/mao/workspace/java/src/BiShi/test4"));

        //组数
        int count=sc.nextInt();

        ArrayList<Integer> nums=new ArrayList<>();

        for(int i=0;i<count;i++){
            //交换次数
            int b=sc.nextInt();
            //元素个数
            int a=sc.nextInt();
            nums.clear();

            for(int j=0;j<a;j++){
                nums.add(sc.nextInt());
            }

            // 交换b次
            while(b>0){
                for(int k=0;k<a;k++){

                    //找到下标
                    int c=findmax(nums,k+1,b);
                    if(nums.get(k)>nums.get(c)){
                        continue;
                    }else{
                        //挪动
                        move(nums,k,c);
                        //挪动次数
                        int m= c-k;
                        b=b-m;
                        break;
                    }
                }
            }


            int m=0;
            for(m=0;m<nums.size()-1;m++){
                System.out.print(nums.get(m)+" ");
            }
            System.out.println(nums.get(m));
        }
    }
    private static void move(ArrayList<Integer> array,int start, int end){
        int tmp=array.get(end);
        for(int i=end-1;i>=start;i--){
            array.set(i+1,array.get(i));
        }
        array.set(start,tmp);
    }
    private static int findmax(ArrayList<Integer> array,int start, int len){
        int maxIndex=start;
        int max=array.get(start);

        for(int i=start;i<array.size()&&i<start+len;i++){
            if(max<array.get(i)){
                max=array.get(i);
                maxIndex=i;
            }
        }
        return maxIndex;
    }
}
package LeetCode;

import java.util.Arrays;

/**
 * @Classname PartitionEqualSubsetSum_416
 * @Description 将一个乱序的数组拆分成为两半,使得这两半的和相等
 * @Date 19-5-16 下午9:51
 * @Created by mao<tianmao818@qq.com>
 */
public class PartitionEqualSubsetSum_416 {


    public static boolean canPartition(int[] nums) {

        Arrays.sort(nums);
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        if((sum&1)==1){
            return false;
        }
        int len=sum>>1;
        int[] tmp=new int[len+1];
        tmp[0]=1;
        for(int j:nums){
            //每一次都从头来一遍
            for(int k=len;k>=0;k--){
                if(tmp[k]==1){
                    //当前求和加上个j
                    tmp[k+j]=1;
                }
            }
            if(tmp[len]==1){
               return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[] test={1,11,5,5,5};
        System.out.println(canPartition(test));
    }
}

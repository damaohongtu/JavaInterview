package JianZhiOffer;

import java.util.Arrays;

/**
 * @Classname MaxContinuousArray
 * @Description 求连续数组最大和
 * @Date 19-3-4 上午9:16
 * @Created by mao<tianmao818@qq.com>
 */
public class MaxContinuousArray {
    public int maxSUm(int[] nums){
        int len=nums.length;
        int[] temp=new int[len];
        temp[0]=nums[0];
        for(int i=1;i<len;i++){
            if(temp[i-1]<0){
                temp[i]=nums[i];
            }else {
                temp[i]=temp[i-1]+nums[i];
            }
        }
        return max(temp);
    }
    public int max(int[] temp){
        int result=temp[0];
        for(int i=1;i<temp.length;i++){
            if(result<temp[i]){
                result=temp[i];
            }
        }
        return result;
    }
    public static void main(String[] args){
        MaxContinuousArray maxContinuousArray=new MaxContinuousArray();
        int[] test={1,-2,3,10,-4,7,2,-5};
        System.out.println(maxContinuousArray.maxSUm(test));
    }
}
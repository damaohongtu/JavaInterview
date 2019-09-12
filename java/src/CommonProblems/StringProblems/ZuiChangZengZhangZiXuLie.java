package CommonProblems.StringProblems;

import java.util.Arrays;

/**
 * @Author MaoTian
 * @Classname ZuiChangZengZhangZiXuLie
 * @Description 最长增长子序列
 * @Date 下午1:00 2019/8/15
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class ZuiChangZengZhangZiXuLie {
    public int getMaxInc(int[] nums){

        int[]tmp=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            tmp[i]=1;
        }
        for(int i=0;i<nums.length;i++){
            for (int j = 0; j <i ; j++) {
                if(nums[j]<nums[i]&&(tmp[j]+1>tmp[i])){
                    tmp[i]=tmp[j]+1;
                }
            }

        }
        int maxLen = 0;
        for (int i = 0; i < nums.length ; i++) {
            if (maxLen < tmp[i]) {
                maxLen = tmp[i];
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int[] nums={2,3,1,9,4,5,6};
        ZuiChangZengZhangZiXuLie z=new ZuiChangZengZhangZiXuLie();
        System.out.println(z.getMaxInc(nums));
    }
}

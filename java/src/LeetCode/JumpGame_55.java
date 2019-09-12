package LeetCode;/**
 * @Classname JumpGame_55
 * @Description 跳远,数组指定每一步的长度,判断能否到达结尾
 * 思路:动态规划?实际更加像递归
 * 定义一个可达的状态 a[n],其中a[i]表示下标i是可以达到的
 * @Date 19-5-21 上午8:27
 * @Created by mao<tianmao818@qq.com>
 */
public class JumpGame_55 {
    public boolean canJump(int[] nums) {
        int len=nums.length;
        boolean a[]=new boolean[len];
        if(len==0){
            return false;
        }

        a[0]=true;

        for(int i=1;i<len;i++){
            for(int j=0;j<i;j++){
                a[i]=a[i]||(a[j]&&(nums[j]>=(i-j)));

            }
        }


        return a[len-1];
    }
}

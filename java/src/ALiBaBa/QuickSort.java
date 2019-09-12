package ALiBaBa;

import org.junit.Test;

/**
 * @Author MaoTian
 * @Classname QuickSort
 * @Description TODO
 * @Date 上午11:39 2019/8/17
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class QuickSort {
    public void quickSort(int[] nums,int left,int right){
        if(left<right){
            int mid=partition(nums,left,right);
            quickSort(nums,left,mid-1);
            quickSort(nums,mid+1,right);
        }
    }
    public int partition(int[] nums,int left,int right){
        int pos=left;
        int value=nums[pos];
        for (int i=left;i<=right;i++){
            if(nums[i]<value){
                pos++;
                if(pos!=i){
                    int tmp=nums[pos];
                    nums[pos]=nums[i];
                    nums[i]=tmp;
                }
            }
        }
        nums[left]=nums[pos];
        nums[pos]=value;
        return pos;
    }
    @Test
    public void check(){
        int[] nums={2,4,2,6,7,3,2,6,8};
        quickSort(nums,0,nums.length-1);
        for (int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
    }
}

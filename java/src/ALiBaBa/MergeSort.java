package ALiBaBa;

import org.junit.Test;

/**
 * @Author MaoTian
 * @Classname MergeSort
 * @Description TODO
 * @Date 上午11:40 2019/8/17
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class MergeSort {


    public void mergeSort(int[] nums,int left,int right){
        if(left<right){
            int mid=(left+right)>>1;
            mergeSort(nums,left,mid);
            mergeSort(nums,mid+1,right);
            merge(nums,left,right,mid);
        }
    }
    public void merge(int[] nums,int left,int right,int mid){

        int leftPos=left;
        int pos=left;
        int rightPos=mid+1;
        int len=right-left+1;
        int[] tmp=new int[nums.length];

        while(leftPos<=mid&&rightPos<=right){
            if(nums[leftPos]>nums[rightPos]){
                tmp[pos++]=nums[rightPos++];
            }else{
                tmp[pos++]=nums[leftPos++];
            }
        }

        while(leftPos<=mid){
            tmp[pos++]=nums[leftPos++];
        }

        while(rightPos<=right){
            tmp[pos++]=nums[rightPos++];
        }
        int m=left;
        int n=left;
        for(int i=0;i<len;i++){
            nums[m++]=tmp[n++];
        }
    }
    @Test
    public void check(){
        int[] nums={2,4,2,5,73,2};
        mergeSort(nums,0,nums.length-1);
        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
    }

}

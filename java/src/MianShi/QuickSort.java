package MianShi;

/**
 * @Author MaoTian
 * @Classname QuickSort
 * @Description 快速排序的实现
 * @Date 下午7:13 2019/8/12
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class QuickSort {

    public int partition(int[] nums,int start,int end){
        int pre=start;
        int standard=nums[start];

        for(int i=start+1;i<=end;i++){
            if(nums[i]<standard){
                pre++;
                if(pre!=i){
                    int tmp=nums[i];
                    nums[i]=nums[pre];
                    nums[pre]=tmp;
                }
            }
        }

        nums[start]=nums[pre];
        nums[pre]=standard;

        return pre;
    }
    public void quickSort(int[] nums,int start,int end){
        if(start<end){
            int mid=partition(nums,start,end);
            quickSort(nums,start,mid-1);
            quickSort(nums,mid+1,end);
        }
    }

    public static void main(String[] args) {

        StringBuffer stringBuffer;

        int[] nums={2,1,7,3,5,9,9,4};
        QuickSort quickSort=new QuickSort();
        quickSort.quickSort(nums,0,nums.length-1);
        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
    }
}

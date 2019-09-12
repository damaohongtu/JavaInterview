package JianZhiOffer;/**
 * @Classname ReorderOddEvent
 * @Description 将奇数排在偶数的前面,但是这里修改了原本的相关顺序
 * @Date 19-3-3 下午8:04
 * @Created by mao<tianmao818@qq.com>
 */
public class ReorderOddEvent {
    public void reorder(int[] nums){
        int beginIndex=0;
        int endIndex=nums.length-1;
        while (beginIndex<endIndex){
            while (beginIndex<endIndex && nums[beginIndex]%2!=0){
                beginIndex++;
            }
            while (beginIndex<endIndex && nums[endIndex]%2==0){
                endIndex--;
            }
            if(beginIndex<endIndex){
                int temp=nums[beginIndex];
                nums[beginIndex]=nums[endIndex];
                nums[endIndex]=temp;
            }
        }
    }
    public static void main(String[] args){
        int nums[]={1,2,3,4,5,6,7,8};
        ReorderOddEvent reorderOddEvent=new ReorderOddEvent();
        reorderOddEvent.reorder(nums);
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+"\t");
        }
    }
}
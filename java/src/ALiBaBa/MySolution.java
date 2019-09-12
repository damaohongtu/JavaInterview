package ALiBaBa;

import org.junit.Test;

/**
 * @Author MaoTian
 * @Classname MySolution
 * @Description TODO
 * @Date 下午4:50 2019/8/19
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class MySolution {
    public int partition(int[] nums,int value){
        //
        int pos=0;
        int position=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==value){
                position=i;
                break;
            }
        }
        int num=nums[0];
        nums[0]=nums[position];
        nums[position]=num;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<value){
                pos++;
                if(nums[i]<value&&pos<nums.length){
                    int tmp=nums[pos];
                    nums[pos]=nums[i];
                    nums[i]=tmp;
                }
            }
        }
        nums[0]=nums[pos];
        nums[pos]=value;
        return pos;
    }
    @Test
    public void check(){
        int[] nums={1,2,7,9,3,4,5,10,8};
        partition(nums,8);
        for (int i = 0; i <nums.length ; i++) {
            System.out.println(nums[i]);
        }
    }
}

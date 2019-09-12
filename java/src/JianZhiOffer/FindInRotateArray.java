package JianZhiOffer;/**
 * @Classname FindInRotateArray
 * @Description TODO
 * @Date 19-3-2 下午1:43
 * @Created by mao<tianmao818@qq.com>
 */
public class FindInRotateArray {
    public int find(int[] nums){
        int index1=0;
        int index2=nums.length-1;
        if(nums[index1]<nums[index2]){
            return nums[0];
        }
        while (index1<index2){
            if(index2-index1==1){
                return nums[index2];
            }
            int mid=(index1+index2)/2;
            if(nums[index1]==nums[index2]){
                return find2(nums,index1,index2);
            }
            if(nums[mid]>nums[index1]){
                index1=mid;
            }else {
                index2=mid;
            }
        }
        return -1;
    }
    public int find2(int[] nums,int index1,int index2){
        int result=nums[index1];
        for(int i=index1+1;i<=index2;i++){
            if(result>nums[i]){
                result=nums[i];
            }
        }
        return result;
    }
    public static void main(String[] args){
        int[] nums={1,2,3,4,5,6,7,8};
        FindInRotateArray findInRotateArray=new FindInRotateArray();
        System.out.println(findInRotateArray.find(nums));
    }
}
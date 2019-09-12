package JianZhiOffer;/**
 * @Classname NumberCount
 * @Description TODO
 * @Date 19-3-5 上午9:31
 * @Created by mao<tianmao818@qq.com>
 */
public class NumberCount {
    public int getFirstK(int[] nums, int k, int length, int start, int end){
//        if(start>end){
//            return -1;
//        }
        int mid=(start+end)/2;
        if(nums[mid]==k){
            if((mid>0 && nums[mid-1]!=k) || mid==0){
                return mid;
            }else {
                end=mid-1;
            }

        }else if(nums[mid]>k){
            end=mid-1;
        }else {
            start=mid+1;
        }
        return getFirstK(nums,k,length,start,end);
    }
    public int getLastK(int[] nums, int k, int length, int start, int end){
//        if(start>end){
//            return -1;
//        }
        int mid=(start+end)/2;
        int midData=nums[mid];
        if(midData==k){
            if((mid<length-1 && nums[mid+1]!=k) || mid==length-1){
                return mid;
            }else {
                start=mid+1;
            }
        }else if(midData>k){
            end=mid-1;
        }else {
            start=mid+1;
        }
        return getLastK(nums,k,length,start,end);
    }
    public int getNumOfK(int[] nums, int k){
        int length=nums.length;
        return getLastK(nums,k,length,0,length-1)-getFirstK(nums,k,length,0,length-1)+1;
    }
    public static void main(String[] args){
        int[] test={1,2,3,3,3,3,4,5};
        NumberCount numberCount=new NumberCount();
        System.out.println(numberCount.getNumOfK(test,3));
    }
}
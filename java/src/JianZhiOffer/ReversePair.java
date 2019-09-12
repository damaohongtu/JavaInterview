package JianZhiOffer;/**
 * @Classname ReversePair
 * @Description TODO
 * @Date 19-3-12 下午2:59
 * @Created by mao<tianmao818@qq.com>
 */
public class ReversePair {
    public int InversePairs(int [] array) {
        int len=array.length;
        if(array==null || array.length<=0)
            return 0;
        if(len<2){
            return 0;
        }
        return helper(array,0,len-1);
    }
    private int helper(int[] array, int start, int end){
        if(start>=end){
            return 0;
        }
        int mid=(start+end)>>1;

        int left=helper(array,start,mid);
        int right=helper(array,mid+1,end);

        int i=mid;
        int j=end;
        int count=0;

        int[] temp=new int[end-start+1];
        int k=end-start;

        while(i>=start && j>=mid+1){
            if(array[i]>array[j]){
                count+=(j-mid);
                temp[k--]=array[i--];
            }else{
                temp[k--]=array[j--];
            }
        }

        while(i>=start){
            temp[k--]=array[i--];
        }

        while(j>=mid+1){
            temp[k--]=array[j--];
        }
        for(int m=0;m<end-start+1;m++){
            array[start+m]=temp[m];
        }
        return count+left+right;
    }
    public static void main(String[] args){
        ReversePair reversePair=new ReversePair();
        int[] test={7,6,5,4};
        System.out.println(reversePair.InversePairs(test));
        System.out.println("after pair sort:");
        for(int i=0;i<test.length;i++){
            System.out.println(test[i]);
        }
    }
}
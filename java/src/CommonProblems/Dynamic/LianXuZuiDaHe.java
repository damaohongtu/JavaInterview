package CommonProblems.Dynamic;

/**
 * @Author MaoTian
 * @Classname LianXuZuiDaHe
 * @Description 连续最大加和
 * @Date 下午1:46 2019/8/15
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class LianXuZuiDaHe {
    public int getMax(int[] nums){
        int n=nums.length;
        int[] tmp=new int[n+1];
        tmp[0]=0;
        for(int i=1;i<=n;i++){
            if(tmp[i-1]>=0){
                tmp[i]=tmp[i-1]+nums[i-1];
            }else {
                tmp[i]=nums[i-1];
            }
        }
        int max=tmp[1];
        for(int j=2;j<=n;j++){
            if(tmp[j]>max){
                max=tmp[j];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,-21,5,6};
        LianXuZuiDaHe l=new LianXuZuiDaHe();
        System.out.println(l.getMax(nums));
    }
}

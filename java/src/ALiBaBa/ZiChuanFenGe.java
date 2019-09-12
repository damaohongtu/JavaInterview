package ALiBaBa;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @Author MaoTian
 * @Classname ZiChuanFenGe
 * @Description TODO
 * @Date 上午9:04 2019/8/17
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class ZiChuanFenGe {
    public int[] getPosition(int[] nums){
        int[] res=new int[3];
        int p1=getMid(nums,0,nums.length-1);
        if(p1==-1){
            return res;
        }
        int p0=getMid(nums,0,p1-1);
        int p2=getMid(nums,p1+1,nums.length-1);
        if((p0!=-1)&&(p2!=-1)){
            res[0]=p0;
            res[1]=p1;
            res[2]=p2;
        }
        return res;
    }
    public int getMid(int[]nums,int start,int end){
        if(end-start<2){
            return -1;
        }
        for(int i=start+1;i<end;i++){
            int left=0;
            for(int j=start;j<i;j++){
                left+=nums[j];
            }

            int right=0;
            for(int k=i+1;k<=end;k++){
                right+=nums[k];
            }
            if(left==right){
                return i;
            }
        }
        return -1;
    }

    @Test
    public void check(){
        int[] nums = {2,3,4,1,9,1,8,1,1,1,2,3,3};
        int[] res=getPosition(nums);
        for (int i=0;i<3;i++){
            System.out.println(res[i]);
        }
    }


}

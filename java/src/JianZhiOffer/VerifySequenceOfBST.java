package JianZhiOffer;

import java.util.Arrays;

/**
 * @Classname VerifySequenceOfBST
 * @Description 判断给定数组是否是一棵二叉搜索树的后序遍历,java中array不能够使用指针,可以定义一个start来进行移动!
 * @Date 19-3-4 上午10:47
 * @Created by mao<tianmao818@qq.com>
 */
public class VerifySequenceOfBST {
    public boolean verify(int[] nums,int length,int start){

        int root=nums[length-1];
        int i=start;
        for(;i<length-1;++i){
            if(nums[i]>root){
                break;
            }
        }
        int j=i;
        for(;j<length-1;++j){
            if(nums[j]<root){
                return false;
            }
        }
        boolean left=true;
        if(i>0){
            left=verify(nums,i,0);
        }
        boolean right=true;
        if(i<length-1){
            right=verify(nums,length-i-1,i);
        }
        return left && right;
    }
    public static void main(String[] args){
        int[] test1={7,4,6,5};
        int[] test2={5,7,6,9,11,10,8};
        VerifySequenceOfBST verifySequenceOfBST=new VerifySequenceOfBST();
        System.out.println(verifySequenceOfBST.verify(test1,test1.length,0));
        System.out.println(verifySequenceOfBST.verify(test2,test2.length,0));
    }
}
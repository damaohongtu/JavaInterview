package BiShi.LaoHu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @Author MaoTian
 * @Classname LaoHu_1
 * @Description TODO
 * @Date 下午8:20 2019/9/2
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class LaoHu_2 {
//    public static void main(String[] args) throws FileNotFoundException {
////        Scanner sc=new Scanner(new File("/home/mao/workspace/java/src/BiShi/pinDuoDuo0901/test2"));
//        Scanner sc=new Scanner(System.in);
//        while (sc.hasNext()){
//
//        }
//    }
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val=val;
        }
    }
    public boolean isBalanced(TreeNode root){
        return getDepth(root)==-1;
    }
    int getDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=getDepth(root.left);
        if(left==-1){
            return -1;
        }
        int right=getDepth(root.right);
        if(left==-1){
            return -1;
        }
        return Math.abs(left-right)>1?-1:Math.max(left,right);
    }





}

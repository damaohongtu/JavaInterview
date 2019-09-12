package BiShi;

import sun.reflect.generics.tree.Tree;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author MaoTian
 * @Classname Zoom2
 * @Description TODO
 * @Date 下午3:01 2019/8/17
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
class TreeNode{
    String val;
    TreeNode left;
    TreeNode right;
    TreeNode(String val){
        this.val=val;
    }
}



public class Zoom2 {

    TreeNode getTree(String s){
        String[] arr=s.split(",");
        ArrayList<TreeNode> tmp=new ArrayList<>();


        TreeNode root=new TreeNode(arr[0]);
        tmp.add(root);

        int start=1;
        while (!tmp.isEmpty()){
            ArrayList<TreeNode> middle=new ArrayList<>();
            for(TreeNode t:tmp){

                if(start<arr.length){
                    TreeNode left=new TreeNode(arr[start++]);
                    middle.add(left);
                    t.left=left;
                }else {
                    t.left=null;
                }
                if(start<arr.length){
                    TreeNode right=new TreeNode(arr[start++]);
                    middle.add(right);
                    t.right=right;
                }else {
                    t.right=null;
                }

            }
            tmp.clear();
            tmp.addAll(middle);
        }

        return root;
    }



    public static void main(String[] args)throws Exception {
        Scanner sc =new Scanner(new File("/home/mao/workspace/java/src/BiShi/test2"));
        //Scanner sc =new Scanner(System.in);
        while(sc.hasNext()){

        }
    }
}

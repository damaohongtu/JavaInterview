package ByteDancePreparation;

import java.util.LinkedList;

/**
 * @Author MaoTian
 * @Classname Tree2List
 * @Description 将二叉搜索树转换为双向链表，使用递归和非递归的方式
 * @Date 下午9:09 2019/9/14
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
}
public class Tree2List {
    //递归
    public TreeNode convert2(TreeNode root){
        TreeNode head=null;
        return head;
    }
    public void travel(TreeNode root){

    }
    //非递归
    public TreeNode convert1(TreeNode root){

        TreeNode head=null;
        TreeNode pre=null;
        LinkedList<TreeNode> tmp=new LinkedList<>();

        while (root!=null  || !tmp.isEmpty()){

            //左边
            while (root!=null){
                tmp.push(root);
                root=root.left;
            }

            TreeNode node=tmp.pop();

            if(head==null){
                head=node;
                pre=node;
            }else {
                node.left=pre;
                pre.right=node;
                pre=node;
            }
            root=root.right;
        }

        return head;
    }
}

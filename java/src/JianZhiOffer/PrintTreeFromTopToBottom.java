package JianZhiOffer;

import java.util.ArrayList;

/**
 * @Author MaoTian
 * @Classname PrintTreeFromTopToBottom
 * @Description 从上往下打印二叉树
 * @Date 上午9:49 2019/8/12
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class PrintTreeFromTopToBottom {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public ArrayList<ArrayList<Integer>>print(TreeNode root){
        ArrayList<ArrayList<Integer>>ans=new ArrayList<>();
        ArrayList<TreeNode> tmp=new ArrayList<>();
        if(root==null){
            return ans;
        }
        tmp.add(root);
        int cur=0;
        int next=1;
        while(!tmp.isEmpty()){
            ArrayList<Integer> level=new ArrayList<>();
            cur=next;
            next=0;
            for(int i=0;i<cur;i++){
                TreeNode node=tmp.get(0);
                tmp.remove(0);
                level.add(node.val);
                if(node.left!=null){
                    tmp.add(node.left);
                    next++;
                }
                if(node.right!=null){
                    tmp.add(node.right);
                    next++;
                }
            }
            ans.add(level);
        }
        return ans;
    }

    public static void main(String[] args) {
        PrintTreeFromTopToBottom p=new PrintTreeFromTopToBottom();
        PrintTreeFromTopToBottom.TreeNode node6=p.new TreeNode(6);
        PrintTreeFromTopToBottom.TreeNode node5=p.new TreeNode(5);
        PrintTreeFromTopToBottom.TreeNode node4=p.new TreeNode(4);
        PrintTreeFromTopToBottom.TreeNode node3=p.new TreeNode(3);
        PrintTreeFromTopToBottom.TreeNode node2=p.new TreeNode(2);
        PrintTreeFromTopToBottom.TreeNode node1=p.new TreeNode(1);

        node1.left=node2;node1.right=node3;node2.left=node4;node2.right=node5;node3.left=node6;node3.right=null;
        node4.left=null;node4.right=null;node5.left=null;node5.right=null;node6.left=null;node6.right=null;

        ArrayList<ArrayList<Integer>>res=p.print(node1);
        for(ArrayList<Integer> i:res){
            System.out.println(i);
        }

    }
}

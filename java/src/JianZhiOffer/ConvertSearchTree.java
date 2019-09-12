package JianZhiOffer;/**
 * @Classname ConvertSearchTree
 * @Description TODO
 * @Date 19-3-5 下午6:53
 * @Created by mao<tianmao818@qq.com>
 */
import BinaryTree.BinaryTreeNode;
public class ConvertSearchTree {
    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    // 当前结点的前驱
    private TreeNode preNode;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }

        TreeNode root = pRootOfTree;
        // 得到双向链表
        inOrder(root);
        // 向左找到双向链表的头结点
        while (root.left != null) {
            root = root.left;
        }
        return root;

    }

    // 中序遍历并改变指针
    private void inOrder(TreeNode node) {
        if (node == null) return;

        inOrder(node.left);

        node.left = preNode;
        if (preNode != null) {
            preNode.right = node;
        }
        preNode = node;

        inOrder(node.right);
    }
    public static void main(String[] args){
        BinaryTreeNode node7=new BinaryTreeNode(16,null,null);
        BinaryTreeNode node6=new BinaryTreeNode(12,null,null);
        BinaryTreeNode node5=new BinaryTreeNode(8,null,null);
        BinaryTreeNode node4=new BinaryTreeNode(4,null,null);
        BinaryTreeNode node3=new BinaryTreeNode(14,node6,node7);
        BinaryTreeNode node2=new BinaryTreeNode(6,node4,node5);
        BinaryTreeNode node1=new BinaryTreeNode(10,node2,node3);

        ConvertSearchTree convertSearchTree=new ConvertSearchTree();

//        BinaryTreeNode res=convertSearchTree.convert(node1);
//        System.out.println(res==null);
//        while (res.getLeft()!=null){
//            System.out.println(res.getData());
//            res=res.getLeft();
//        }
    }
}
package LeetCode;/**
 * @Classname InvertBinaryTree_226
 * @Description 交换二叉树的左右孩子节点
 * @Date 19-6-3 上午9:34
 * @Created by mao<tianmao818@qq.com>
 */
public class InvertBinaryTree_226 {
    public TreeNode invertTree(TreeNode root) {
        if(root!=null){
            TreeNode left=root.left;
            TreeNode right=root.right;
            root.left=right;
            root.right=left;
            invertTree(left);
            invertTree(right);
        }
        return root;
    }
}

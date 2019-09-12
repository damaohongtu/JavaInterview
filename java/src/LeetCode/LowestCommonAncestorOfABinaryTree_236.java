package LeetCode;/**
 * @Classname LowestCommonAncestorOfABinaryTree_236
 * @Description 求二叉树中两个节点的最低公共父节点
 * @Date 19-5-21 下午4:31
 * @Created by mao<tianmao818@qq.com>
 */

public class LowestCommonAncestorOfABinaryTree_236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        } else{
            return find(root, p, q);
        }
    }

    TreeNode find(TreeNode node, TreeNode p, TreeNode q){


        // 找到了一个节点
        if(node == p || node == q){
            return node;
        } else{

            TreeNode left = null;
            if(node.left != null){
                left = find(node.left, p , q);
            }

            TreeNode right = null;
            if(node.right != null){
                right = find(node.right, p , q);
            }

            // 在当前节点的左子树和右子树中
            if(left != null && right != null){
                return node;
            }
            // 全在左子树中
            else  if(left != null){
                return left;
            }
            // 全在右子树中
            else{
                return right;
            }
        }
    }
}

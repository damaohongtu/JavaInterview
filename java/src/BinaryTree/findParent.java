package BinaryTree;/**
 * @Classname findParent
 * @Description 寻找公共祖先
 * @Date 19-3-16 下午2:43
 * @Created by mao<tianmao818@qq.com>
 *        1
 *     2      3
 *   4  5   6   7
 *
 *
 *
 *
 */
public class findParent {
    public BinaryTreeNode find(BinaryTreeNode root,BinaryTreeNode node1,BinaryTreeNode node2){
        if(root==null || root==node1 || root==node2){
            return root;
        }
        BinaryTreeNode left=find(root.getLeft(),node1,node2);
        BinaryTreeNode right=find(root.getRight(),node1,node2);


        return left==null? right : right==null?left:root;
    }

    public BinaryTreeNode find2(BinaryTreeNode root,BinaryTreeNode node1,BinaryTreeNode node2){
        while(true) {
            if(root==null){
                return root;
            }

            if (root.getLeft().getData() > node1.getData() && root.getLeft().getData() < node2.getData()) {
                root = root.getLeft();
            } else if (root.getRight().getData() > node1.getData() && root.getRight().getData() < node2.getData()) {
                root = root.getRight();
            } else {
                return root;
            }
        }
    }
}

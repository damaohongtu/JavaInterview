package JianZhiOffer;/**
 * @Classname MirrorTree
 * @Description TODO
 * @Date 19-3-4 下午4:39
 * @Created by mao<tianmao818@qq.com>
 */
import CommonProblems.BinaryTree.BinaryTreeNode;
import CommonProblems.BinaryTree.Traversal;
public class MirrorTree {
    public void mirror(BinaryTreeNode root){
        if(root==null){
            return;
        }
        if(root.getRight()==null && root.getLeft()==null){
            return;
        }
        BinaryTreeNode temp=root.getRight();
        root.setRight(root.getLeft());
        root.setLeft(temp);
        if(root.getLeft()!=null){
            mirror(root.getLeft());
        }
        if(root.getRight()!=null){
            mirror(root.getRight());
        }
    }
    public static void main(String[] args){
        MirrorTree mirrorTree=new MirrorTree();
        Traversal traversal=new Traversal();

        BinaryTreeNode node5=new BinaryTreeNode(7,null,null);
        BinaryTreeNode node4=new BinaryTreeNode(4,null,null);
        BinaryTreeNode node3=new BinaryTreeNode(12,null,null);
        BinaryTreeNode node2=new BinaryTreeNode(5,node4,node5);
        BinaryTreeNode node1=new BinaryTreeNode(10,node2,node3);
        traversal.levelorder(node1);
        System.out.println();
        mirrorTree.mirror(node1);
        traversal.levelorder(node1);
    }
}
package JianZhiOffer;/**
 * @Classname BinaryTreeDepth
 * @Description TODO
 * @Date 19-3-4 下午3:36
 * @Created by mao<tianmao818@qq.com>
 */
import BinaryTree.BinaryTreeNode;
public class BinaryTreeDepth {
    public int getDeep(BinaryTreeNode root){
        int deep=0;
        if(root==null){
            deep=0;
        }else {
            deep=max(getDeep(root.getLeft()),getDeep(root.getLeft()))+1;
        }
        return deep;
    }
    public int max(int a,int b){
        return a>b?a:b;
    }
    public static void main(String[] args){
        BinaryTreeNode node5=new BinaryTreeNode(7,null,null);
        BinaryTreeNode node4=new BinaryTreeNode(4,null,null);
        BinaryTreeNode node3=new BinaryTreeNode(12,null,null);
        BinaryTreeNode node2=new BinaryTreeNode(5,node4,node5);
        BinaryTreeNode node1=new BinaryTreeNode(10,node2,node3);
        BinaryTreeDepth binaryTreeDepth=new BinaryTreeDepth();
        System.out.println(binaryTreeDepth.getDeep(node1));
    }
}
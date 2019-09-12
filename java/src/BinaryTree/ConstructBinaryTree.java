package BinaryTree;
import BinaryTree.BinaryTreeNode;

import java.net.PortUnreachableException;

public class ConstructBinaryTree {

    public static BinaryTreeNode construct1(int[] preOrder,int[] inOrder, int length){
        if(preOrder==null||inOrder==null||length<0){

            return null;
        }
        try {
            return ConstructCore1(preOrder, 0, preOrder.length - 1, inOrder, 0,inOrder.length - 1);
        }catch (Exception e){
            return null;
        }
    }


    public static BinaryTreeNode ConstructCore1(int[] preOrder,int startPreIndex, int endPreIndex,
                                               int[] inOrder,int startInIndex, int endInIndex) throws InvalidPutException {
        int rootValue = preOrder[startPreIndex];
        BinaryTreeNode root = new BinaryTreeNode(rootValue,null,null);
        // 在中序遍历中找到根结点的索引
        int rootInIndex = startInIndex;
        while (rootInIndex <= endInIndex && inOrder[rootInIndex] != rootValue) {
            ++rootInIndex;
        }
        if (rootInIndex == endInIndex && inOrder[rootInIndex] != rootValue) {
            throw new InvalidPutException();
        }
        int leftLength = rootInIndex - startInIndex;
        int leftPreOrderEndIndex = startPreIndex + leftLength;
        if (leftLength > 0) {
            // 构建左子树
            root.setLeft( ConstructCore1(preOrder, startPreIndex + 1,
                    leftPreOrderEndIndex, inOrder, startInIndex,
                    rootInIndex - 1));
        }

        if (leftLength < endPreIndex - startPreIndex) {
            // 右子树有元素,构建右子树
            root.setRight(ConstructCore1(preOrder, leftPreOrderEndIndex + 1,
                    endPreIndex, inOrder, rootInIndex + 1, endInIndex));
        }
        return root;
    }

    public static BinaryTreeNode construct2(int[] postOrder,int[] inOrder,int length){
        return ConstructCore2(postOrder,0,postOrder.length-1,inOrder,0,inOrder.length-1);
    }
    public static BinaryTreeNode ConstructCore2(int[] postOrder,int startPostIndex,int endPostIndex,int[] inOrder,int startInIndex,int endInIndex){
        int rootValue=postOrder[endPostIndex];
        BinaryTreeNode root=new BinaryTreeNode(rootValue,null,null);

        int rootInIndex=startInIndex;
        while(rootInIndex<=endInIndex&&inOrder[rootInIndex]!=rootValue){
            ++rootInIndex;
        }

        int leftLength=rootInIndex-startInIndex;
        int rightLength=endInIndex-rootInIndex;

        int leftPostOrderEndIndex=startPostIndex+leftLength-1;
        if(leftLength>0){
            root.setLeft(ConstructCore2(postOrder,startPostIndex,leftPostOrderEndIndex,inOrder,startInIndex,rootInIndex-1));
        }
        if(rightLength>0){
            root.setRight(ConstructCore2(postOrder,rootInIndex,endPostIndex-1,inOrder,rootInIndex+1,endInIndex));
        }

        return root;
    }

    static class InvalidPutException extends Exception {
        private static final long serialVersionUID = 1L;
    }

    public static void main(String[] argv){
        int[] preOrder={1,2,4,5,8,9,10,3,6,7};
        int[] inOrder={4,2,8,5,9,10,1,6,3,7};
        int[] postOrder={4,8,10,9,5,2,6,7,3,1};
        BinaryTreeNode root=ConstructBinaryTree.construct1(preOrder,inOrder,10);
        BinaryTreeNode root2=ConstructBinaryTree.construct2(postOrder,inOrder,10);
        Traversal traversal=new Traversal();
        System.out.println("preOrder+inOrder");
        traversal.postorder3(root);
        System.out.println();
        System.out.println("postOrder+inOrder");
        traversal.preorder1(root2);
    }

}

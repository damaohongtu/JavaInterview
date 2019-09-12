package BinaryTree;
import BinaryTree.BinaryTreeNode;
//树的遍历

import java.util.*;

public class Traversal {


    public void preorder1(BinaryTreeNode root){
        if (root==null)
            return;
        System.out.print(root.getData()+"\t");
        preorder1(root.getLeft());
        preorder1(root.getRight());
    }
    public void preorder2(BinaryTreeNode root){
        Stack<BinaryTreeNode>stack =new Stack<BinaryTreeNode>();
        if (root==null)
            return;
        BinaryTreeNode cur;
        cur=root;
        while(cur!=null||!stack.isEmpty()){
            if (cur!=null){
                System.out.print(cur.getData()+"\t");
                stack.push(cur);
                cur=cur.getLeft();
            }else{
                cur=stack.peek();
                stack.pop();
                cur=cur.getRight();
            }
        }
    }
    public void inorder1(BinaryTreeNode root){
        if (root==null)
            return;
        inorder1(root.getLeft());
        System.out.print(root.getData()+"\t");
        inorder1(root.getRight());
    }
    public void inorder2(BinaryTreeNode root){
        Stack<BinaryTreeNode>stack =new Stack<BinaryTreeNode>();
        if(root==null)
            return;
        BinaryTreeNode cur=root;
        while(cur!=null||!stack.isEmpty()){
            if(cur!=null){
                stack.push(cur);
                cur=cur.getLeft();
            }else{
                cur=stack.peek();
                stack.pop();
                System.out.print(cur.getData()+"\t");
                cur=cur.getRight();
            }
        }
    }
    public void postorder1(BinaryTreeNode root){
        if (root==null)
            return;
        postorder1(root.getLeft());
        postorder1(root.getRight());
        System.out.print(root.getData()+"\t");
    }
    public void postorder2(BinaryTreeNode root){
        Stack<BinaryTreeNode> stack=new Stack<BinaryTreeNode>();
        while (true){
            if(root!=null){
                stack.push(root);
                root=root.getLeft();
            }
            else {
                if(stack.isEmpty())
                    return;
                if(stack.lastElement().getRight()==null){
                    root=stack.pop();
                    System.out.print(root.getData()+"\t");
                    while (stack.lastElement().getRight()==root){
                        System.out.print(stack.lastElement().getData()+"\t");
                        root=stack.pop();
                        if (stack.isEmpty()){
                            break;
                        }
                    }
                }
                if(!stack.isEmpty())
                    root=stack.lastElement().getRight();
                else
                    root=null;
            }
        }
    }
    public void postorder3(BinaryTreeNode root){
        if(root==null)
            return;
        Stack<BinaryTreeNode> stack=new Stack<BinaryTreeNode>();
        BinaryTreeNode cur;
        cur=root;
        List<Integer> res=new ArrayList<>();

        while (cur!=null||!stack.isEmpty()){
            if (cur!=null){
                res.add(cur.getData());
                stack.push(cur);
                cur=cur.getRight();
            }else{
                cur=stack.peek();
                stack.pop();
                cur=cur.getLeft();
            }


        }
        Collections.reverse(res);
        for (Integer i:res){
            System.out.print(i+"\t");
        }
    }
    public void levelorder(BinaryTreeNode root){
        BinaryTreeNode temp;
        Queue<BinaryTreeNode> queue=new LinkedList<BinaryTreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()){
            temp=queue.poll();
            System.out.print(temp.getData()+"\t");
            if(temp.getLeft()!=null){
                queue.offer(temp.getLeft());
            }
            if(temp.getRight()!=null){
                queue.offer(temp.getRight());
            }
        }
    }
    public static void main(String[] args){
        BinaryTreeNode node10=new BinaryTreeNode(10,null,null);
        BinaryTreeNode node8=new BinaryTreeNode(8,null,null);
        BinaryTreeNode node9=new BinaryTreeNode(9,null,node10);
        BinaryTreeNode node4=new BinaryTreeNode(4,null,null);
        BinaryTreeNode node5=new BinaryTreeNode(5,node8,node9);
        BinaryTreeNode node6=new BinaryTreeNode(6,null,null);
        BinaryTreeNode node7=new BinaryTreeNode(7,null,null);
        BinaryTreeNode node2=new BinaryTreeNode(2,node4,node5);
        BinaryTreeNode node3=new BinaryTreeNode(3,node6,node7);
        BinaryTreeNode node1=new BinaryTreeNode(1,node2,node3);


        Traversal traversal=new Traversal();


        System.out.println("---pre order---");
        traversal.preorder1(node1);
        System.out.println();
        traversal.preorder2(node1);
        System.out.println();

        System.out.println("---in order---");
        traversal.inorder1(node1);
        System.out.println();
        traversal.inorder2(node1);
        System.out.println();

        System.out.println("---post order---");
        traversal.postorder1(node1);
        System.out.println();
        traversal.postorder2(node1);
        System.out.println();
        traversal.postorder3(node1);
        System.out.println();

        System.out.println("---level order---");
        traversal.levelorder(node1);
        System.out.println();
    }
}

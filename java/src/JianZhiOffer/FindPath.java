package JianZhiOffer;
import BinaryTree.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname FindPath
 * @Description TODO
 * @Date 19-3-4 下午2:09
 * @Created by mao<tianmao818@qq.com>
 */
public class FindPath {
    private List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> find(BinaryTreeNode root,int target){

        helper(root,target,0,new ArrayList<>());
        return res;
    }
    public void helper(BinaryTreeNode root,int target,int currentSum,List<Integer> path){

        currentSum+=root.getData();
        path.add(root.getData());
        boolean isLeaf=root.getRight()==null && root.getRight()==null;
        if(isLeaf && currentSum==target){
            List<Integer> temp=new ArrayList<>();
            for(Integer x:path){
                temp.add(x);
            }
            res.add(temp);
        }
        if(root.getLeft()!=null){
            helper(root.getLeft(),target,currentSum,path);
        }
        if(root.getRight()!=null){
            helper(root.getRight(),target,currentSum,path);
        }
        path.remove(path.size()-1);
    }
    public static void main(String[] args){
        BinaryTreeNode node5=new BinaryTreeNode(7,null,null);
        BinaryTreeNode node4=new BinaryTreeNode(4,null,null);
        BinaryTreeNode node3=new BinaryTreeNode(12,null,null);
        BinaryTreeNode node2=new BinaryTreeNode(5,node4,node5);
        BinaryTreeNode node1=new BinaryTreeNode(10,node2,node3);
        FindPath findPath=new FindPath();
        System.out.println(findPath.find(node1,19));
    }
}
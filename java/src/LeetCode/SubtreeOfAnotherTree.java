package LeetCode;/**
 * @Classname SubtreeOfAnotherTree
 * @Description 判断树t是否为树s的子树
 * @Date 19-5-30 上午10:57
 * @Created by mao<tianmao818@qq.com>
 */
public class SubtreeOfAnotherTree {

    public boolean isSubtree(TreeNode s, TreeNode t) {

        boolean ans=false;
        if (s!=null&&t!=null){
            if(s.val==t.val){
                ans=helper(s,t);
            }
            if(!ans){
                ans=isSubtree(s.left,t);
            }
            if(!ans){
                ans=isSubtree(s.right,t);
            }
        }
        return ans;
    }

    public boolean helper(TreeNode s,TreeNode t){

        if(t==null){
            return true;
        }
        if (s==null){
            return false;
        }
        if(s.val!=t.val){
            return false;
        }
        return helper(s.left,t.left)&&helper(s.right,t.right);
    }
}

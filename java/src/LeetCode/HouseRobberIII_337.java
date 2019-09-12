package LeetCode;

import sun.reflect.generics.tree.Tree;

/**
 * @Classname HouseRobberIII_337
 * @Description 在一棵二叉树中寻找和最大,需要保证两个节点之间不能够直接相连
 * 思路: (1)递归
 * 对于当前的这个节点,存在抢与不抢之分
 * @Date 19-5-20 下午3:01
 * @Created by mao<tianmao818@qq.com>
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class HouseRobberIII_337 {
    public int rob(TreeNode root) {
        if (root == null) return 0;
        int[] ret = robHelper(root);
        return Math.max(ret[0], ret[1]);
    }

    private int[] robHelper(TreeNode root) {
        int[] ret = new int[2];
        if (root == null) return ret;

        //返回的是抢和不抢
        int[] lRet = robHelper(root.left);
        //
        int[] rRet = robHelper(root.right);
        //不抢:左右抢与不抢要有判断!!!
        ret[0] = Math.max(lRet[0], lRet[1]) + Math.max(rRet[0], rRet[1]);
        //抢:左右不抢
        ret[1] = lRet[0] + rRet[0] + root.val;
        return ret;
    }
}

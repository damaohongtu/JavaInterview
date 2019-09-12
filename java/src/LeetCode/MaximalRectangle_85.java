package LeetCode;

import java.util.Stack;

/**
 * @Classname MaximalRectangle_85
 * @Description 求解最大的矩形面积,和最大正方形相对应
 *
 * Input:
 * [
 *   ['1','0','1','0','0'],
 *   ['1','0','1','1','1'],
 *   ['1','1','1','1','1'],
 *   ['1','0','0','1','0']
 * ]
 * Output: 6
 *
 * @Date 19-5-23 上午8:50
 * @Created by mao<tianmao818@qq.com>
 */
public class MaximalRectangle_85 {
    public int maximalRectangle(char[][] matrix) {

        //(1)建立矩阵
        int m=matrix.length;
        if(m==0){
            return 0;
        }
        int n=matrix[0].length;
        int[][] heights=new int[m][n];

        for(int i=0;i<n;i++){
            if(matrix[0][i]=='1'){
                heights[0][i]=1;
            }
        }
        for(int i=1;i<m;i++){
            for (int j=0;j<n;j++){
                if(matrix[i][j]=='1'){
                    heights[i][j]=heights[i-1][j]+1;
                }
            }
        }
        //(2)计算每一行对应的最大矩阵(定义一个helper)
        //(3)得到全局的最大矩阵
        int ans=0;
        for (int i=0;i<m;i++){
            ans=Math.max(ans,helper(heights[i]));
        }
        return ans;
    }

    public int helper(int[] height) {
        Stack<Integer> s = new Stack<>();
        int n = height.length;
        int max = 0;
        for (int i = 0; i <= n; ++i) {
            int cur = (i == n) ? -1 : height[i];
            while (!s.isEmpty() && cur < height[s.peek()]) {
                int h = height[s.pop()];
                int w = s.isEmpty() ? i : i - s.peek() - 1;
                max = Math.max(max, h * w);
            }
            s.push(i);
        }
        return max;
    }
    public static void main(String[] args){
        MaximalRectangle_85 maximalRectangle_85=new MaximalRectangle_85();
        char[][] test={{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalRectangle_85.maximalRectangle(test));

    }
}

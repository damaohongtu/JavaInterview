package LeetCode;/**
 * @Classname MinimumPathSum
 * @Description 注意leetcode的意思是向下,向右走,不能向上向左走
 * @Date 19-2-28 下午3:27
 * @Created by mao<tianmao818@qq.com>
 */
public class MinimumPathSum {
//    public int minPathSum(int[][] grid) {
//        int result=0;
//        int m=grid.length;
//        int n=grid[0].length;
//        int visited[][]=new int[m][n];
//
//        for(int i=0;i<m;i++){
//            for(int j=0;j<n;j++){
//                visited[i][j]=0;
//            }
//        }
//        return result;
//    }
    public int minPathSum(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(i>0 &&j==0) grid[i][j] += grid[i-1][j];
                else if(i==0&&j>0) grid[i][j] += grid[i][j-1];
                else if(i>0&&j>0) grid[i][j] +=Math.min(grid[i-1][j],grid[i][j-1]);
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
    public static void main(String[] args){
        MinimumPathSum minimumPathSum=new MinimumPathSum();
        int[][] grid={{1,2,3,10},{10,1,10,1},{1,1,10,1},{1,9,10,1},{1,1,1,1}};
        System.out.println(minimumPathSum.minPathSum(grid));
    }
}
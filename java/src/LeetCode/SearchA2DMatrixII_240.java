package LeetCode;/**
 * @Classname SearchA2DMatrixII_240
 * @Description TODO
 * @Date 19-5-21 下午4:48
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 *
 * Given target = 5, return true.
 *
 * Given target = 20, return false.
 * @Created by mao<tianmao818@qq.com>
 *
 */

public class SearchA2DMatrixII_240 {
    //暴力求解
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        if(m==0){
            return false;
        }
        int n = matrix[0].length;

        for (int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==target){
                    return true;
                }
                if(true){

                }
            }
        }
        return false;
    }
    // 优化




}

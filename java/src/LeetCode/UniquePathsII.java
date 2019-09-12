package LeetCode;/**
 * @Classname UniquePathsII
 * @Description TODO
 * @Date 19-2-28 上午11:11
 * @Created by mao<tianmao818@qq.com>
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] path=new int[m][n];
        if(m==1 || n==1){
            return 1;
        }
        for(int i=0;i<m;i++){
            if(obstacleGrid[i][0]==1){
                while (i<m){
                    path[i][0]=0;
                    i++;
                }
            }else {
                path[i][0] = 1;
            }
        }
        for(int j=0;j<n;j++){
            path[0][j]=1;
            if(obstacleGrid[0][j]==1){
                while (j<n){
                    path[0][j]=0;
                    j++;
                }
            }else {
                path[0][j]=1;
            }
        }
        for(int x=1;x<m;x++){
            for(int y=1;y<n;y++){
                if(obstacleGrid[x][y]==1){
                    path[x][y]=0;
                }else {
                    path[x][y] = path[x - 1][y] + path[x][y - 1];
                }
            }
        }
        return path[m-1][n-1];
    }
}
package LeetCode;/**
 * @Classname UniquePaths
 * @Description TODO
 * @Date 19-2-28 上午10:59
 * @Created by mao<tianmao818@qq.com>
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] path=new int[m][n];
        if(m==1 || n==1){
            return 1;
        }
        for(int i=0;i<m;i++){
            path[i][0]=1;
        }
        for(int j=0;j<n;j++){
            path[0][j]=1;
        }
        for(int x=1;x<m;x++){
            for(int y=1;y<n;y++){
                path[x][y]=path[x-1][y]+path[x][y-1];
            }
        }
        return path[m-1][n-1];
    }
}
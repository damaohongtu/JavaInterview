package CommonProblems.LeetCode;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author MaoTian
 * @Classname Leetcode200
 * @Description TODO
 * @Date 下午9:17 2019/8/26
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class Leetcode200 {
    public int numIslands(char[][] grid) {

        ConcurrentHashMap tmp;
        int res=0;
        int m=grid.length;
        if(m==0){
            return 0;
        }
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    res++;
                    dfs(grid,i,j,m,n);
                }
            }
        }
        return res;
    }
    public void dfs(char[][] grid,int i,int j,int m, int n){
        //
        if(i<0||i>=m || j<0|| j>=n || grid[i][j]=='0'){
            return;
        }
        grid[i][j]='0';
        dfs(grid,i-1,j,m,n);
        dfs(grid,i,j-1,m,n);
        dfs(grid,i+1,j,m,n);
        dfs(grid,i,j+1,m,n);

    }
}

package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname NumberOfIslands_200
 * @Description 给定一个二维数组,求岛屿的数目
 * 思路:首先是建立一个图,目标:寻找连通图的个数!!!
 * 方法二:将所有连通的点都变为0,dfs!!!!!!!!!!
 * @Date 19-5-20 下午5:20
 * @Created by mao<tianmao818@qq.com>
 */
public class NumberOfIslands_200 {
    public int numIslands(char[][] grid) {

        //建立HashMap
        // <a,b> 节点a指向节点b
        Map<Integer,Integer> map=new HashMap<>();
        //行数
        int m=grid.length;
        //列数
        int n=grid[0].length;

        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){

                //在中间范围内
                if(0<i&&i<m&&0<j&&j<n){
                    if(grid[i][j]=='1'){
                        if(grid[i-1][j]=='1'){
                            map.put(i*n+j,(i-1)*n+j);
                        }
                        if(grid[i+1][j]=='1'){
                            map.put(i*n+j,(i+1)*n+j);
                        }
                        if(grid[i][j-1]=='1'){
                            map.put(i*n+j,i*n+j-1);
                        }
                        if(grid[i][j+1]=='1'){
                            map.put(i*n+j,i*n+j+1);
                        }
                    }
                }


                //边缘部分


            }
        }



        return helper(map);
    }

    //从连通图中获取
    public int helper(Map<Integer,Integer> map){

        return 0;
    }


    public int numIslands_2(char[][] grid) {
        //行数
        int m=grid.length;
        //列数
        int n=grid[0].length;

        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    ans+=1;
                    dfs(grid,i,j,m,n);
                }
            }
        }
        return ans;
    }
    public void dfs(char[][] grid,int x,int y,int m,int n){
        if(x<0 || y<0 || x>=m || y>=n || grid[x][y]=='0'){
            return;
        }
        grid[x][y]='0';
        dfs(grid,x+1,y,m,n);
        dfs(grid,x-1,y,m,n);
        dfs(grid,x,y-1,m,n);
        dfs(grid,x,y+1,m,n);
    }


}

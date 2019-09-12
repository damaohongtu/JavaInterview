package JianZhiOffer;/**
 * @Classname RobotMoveField
 * @Description 每一次判断四个方向是不是可以行走,本题要注意的是,使用visited可以保证每一次只走了一步,使用visited保证了不是直接跳过去的.
 * @Date 19-3-3 上午9:50
 * @Created by mao<tianmao818@qq.com>
 */
public class RobotMoveField {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public int moveField(int threshold,int rows,int cols){
        if(threshold<0 || rows<=0 || cols<=0){
            return 0;
        }
        boolean[][] visited=new boolean[rows][cols];
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                visited[i][j]=false;
            }
        }
        int result=moveFieldCore(threshold,rows,cols,0,0,visited);

        //打印出矩阵访问矩阵
        for(int i=0;i<rows;i++){
            System.out.print(i);
            for(int j=0;j<cols;j++){
                if(visited[i][j]==false){
                    System.out.print(ANSI_RED + "N" + ANSI_RESET);
                }else {
                    System.out.print(ANSI_GREEN + "Y" + ANSI_RESET);
                }
            }
            System.out.println();
        }
        String s;
        int n=0;

        return result;
    }
    public int moveFieldCore(int threshold,int rows,int cols,int row,int col,boolean[][]visited){
        int count=0;
        if(check(threshold,rows,cols,row,col,visited)){
            visited[row][col]=true;
            count=1+moveFieldCore(threshold,rows,cols,row-1,col,visited)
                    +moveFieldCore(threshold,rows,cols,row+1,col,visited)
                    +moveFieldCore(threshold,rows,cols,row,col-1,visited)
                    +moveFieldCore(threshold,rows,cols,row,col+1,visited);
        }
        return count;
    }
    public boolean check(int thresHold,int rows,int cols,int row,int col, boolean[][]visited){
        if((getSum(row)+getSum(col)<thresHold) &&
                (col<cols && col>=0) && (row<rows && row>=0)
                && !visited[row][col]){
            return true;
        }
        return false;
    }
    public int getSum(int num){
        int result=0;
        while (num>0){
            result+=(num%10);
            num=num/10;
        }
        return result;
    }
    public static void main(String[] args){
        RobotMoveField robotMoveField=new RobotMoveField();
        System.out.println(robotMoveField.moveField(6,10,10));
    }
}
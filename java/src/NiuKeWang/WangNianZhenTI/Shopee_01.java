package NiuKeWang.WangNianZhenTI;

import java.util.Scanner;

/**
 * @Classname Shopee_01
 * @Description TODO
 * @Date 19-7-11 下午2:08
 * @Created by mao<tianmao818@qq.com>
 */
public class Shopee_01 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        while(sc.hasNext()){
            int x=sc.nextInt();
            int y=sc.nextInt();
            long[][] path=new long[x+1][y+1];
            int n=sc.nextInt();
            for(int i=0;i<n;i++){
                int a=sc.nextInt();
                int b=sc.nextInt();
                path[a][b]=-1;
            }

            for(int i=1;i<=x;i++){
                for(int j=1;j<=y;j++){
                    if(i==1&&j==1){
                        path[i][j]=1;
                    }else if(path[i][j]==-1){
                        path[i][j]=0;
                    }else{
                        path[i][j]=path[i][j-1]+path[i-1][j];
                    }
                }
            }

            System.out.println(path[x][y]);
        }
    }
}

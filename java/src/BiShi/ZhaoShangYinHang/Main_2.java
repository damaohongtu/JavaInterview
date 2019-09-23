package BiShi.ZhaoShangYinHang;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author MaoTian
 * @Classname Main_2
 * @Description TODO
 * @Date 下午7:16 2019/9/15
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class Main_2 {
    public static void main(String[] args)throws Exception {
        Scanner sc =new Scanner(new File("/home/mao/workspace/面试/JavaGuide/JavaInterview/java/src/BiShi/ZhaoShangYinHang/main_2"));
        //Scanner sc =new Scanner(System.in);
        while(sc.hasNext()){

            int n=sc.nextInt();
            int[][] tree=new int[n+1][n+1];
            int[][] child=new int[n+1][n+1];

            for (int i = 0; i <n-1 ; i++) {

                int a=sc.nextInt();
                int b=sc.nextInt();
                int c=sc.nextInt();

                child[a][b]=b;

                tree[a][b]=c;
            }

            int[] res=new int[n+1];

            for(int i=n;i>=0;i--){
                res[i]=Integer.MIN_VALUE;
                int flag=0;

                for (int j = i+1; j < n+1; j++) {
                    if(child[i][j]!=0){
                        flag=1;
                        res[i]=Math.max(tree[i][child[i][j]]+res[child[i][j]],res[i]);
                    }
                }
                if(flag==0){
                    res[i]=0;
                }
            }

            for (int i = 1; i <n ; i++) {
                System.out.print(res[i]+" ");
            }
            System.out.println(res[n]);
        }
    }
}

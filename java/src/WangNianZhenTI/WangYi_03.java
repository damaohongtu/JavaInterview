package WangNianZhenTI;

import java.io.File;
import java.util.Scanner;

public class WangYi_03 {
    public static void main(String[] args)throws Exception {
        Scanner sc =new Scanner(new File("/home/mao/workspace/java/src/WangNianZhenTI/test"));
        while (sc.hasNext()){
            int n=sc.nextInt();
            int[][] locate=new int[n][4];
            for(int i=0;i<n;i++){
                locate[i][0]=sc.nextInt();
            }
            for(int i=0;i<n;i++){
                locate[i][1]=sc.nextInt();
            }
            for(int i=0;i<n;i++){
                locate[i][2]=sc.nextInt();
            }
            for(int i=0;i<n;i++){
                locate[i][3]=sc.nextInt();
            }

            int[] X=new int[2*n];
            int[] Y=new int[2*n];
            for(int i=0;i<n;i++){
                X[i]=locate[i][0];
                Y[i]=locate[i][1];
            }

            for(int i=0;i<n;i++){
                X[i+n]=locate[i][2];
                Y[i+n]=locate[i][3];
            }
            int ans=0;
            for(int i=0;i<2*n;i++){
                for(int j=0;j<2*n;j++){
                    int count=0;
                    int x=X[i];
                    int y=Y[j];
                    for(int k=0;k<n;k++){
                        if((locate[k][0]<=x)&&(x<locate[k][2])&&(locate[k][1]<=y)&&(y<locate[k][3])){
                            count++;
                        }
                    }
                    ans=Math.max(ans,count);
                }
            }
            System.out.println(ans);
        }
    }
}

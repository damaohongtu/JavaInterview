package WangNianZhenTI;

import java.io.File;
import java.util.Scanner;

public class WangYi_02 {
    public static boolean check(int a,int b,int k){
        if(a%b<k){
            return false;
        }
        return true;
    }
    public static void main(String[] args)throws Exception {
        Scanner sc=new Scanner(new File("/home/mao/workspace/java/src/WangNianZhenTI/test"));
        while (sc.hasNext()){
            int n=sc.nextInt();
            int k=sc.nextInt();
            int count=0;
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(check(i,j,k)){
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}

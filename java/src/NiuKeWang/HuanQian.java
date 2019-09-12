package NiuKeWang;

import java.util.Scanner;

/**
 * @Classname HuanQian
 * @Description TODO
 * @Date 19-6-1 上午11:27
 * @Created by mao<tianmao818@qq.com>
 */

public class HuanQian {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            //1、5、10、20、50、100
            long[] ans=new long[n+1];
            ans[0]=1L;
            int arr[]={1,5,10,20,50,100};

            for(int i=0;i<arr.length;i++){
                for(int j=1;j<=n;j++){
                    if(j>=arr[i]){
                        ans[j]=ans[j]+ans[j-arr[i]];
                    }
                }
            }


            System.out.println(ans[n]);
        }
    }
}

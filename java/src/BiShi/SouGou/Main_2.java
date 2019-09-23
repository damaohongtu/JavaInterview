package BiShi.SouGou;

import java.io.File;
import java.util.Scanner;

/**
 * @Author MaoTian
 * @Classname Main_2
 * @Description TODO
 * @Date 下午7:56 2019/9/16
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class Main_2 {
    public static void change(long[] res,int a,int b,int i){
        for(int c=a;c<=b;c++){
            res[c]=i;
        }
    }
    public static void main(String[] args)throws Exception {
        Scanner sc =new Scanner(new File("/home/mao/workspace/面试/JavaGuide/JavaInterview/java/src/BiShi/SouGou/main_2"));
        //Scanner sc =new Scanner(System.in);
        while(sc.hasNext()){
            int N=sc.nextInt();
            int M=sc.nextInt();
            
            long[] res=new long[N];

            for (int i = 1; i <=M ; i++) {
                int a=sc.nextInt();
                int b=sc.nextInt();
                change(res,a,b,i);
            }

            long ans=0;
            for (int i = 0; i <N ; i++) {
                ans+=i*(res[i]%100000009);
            }
            System.out.println(ans%100000009);
        }
    }
}

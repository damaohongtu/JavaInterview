package BiShi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Classname BeiBao_all
 * @Description TODO
 * @Date 19-6-9 下午7:34
 * @Created by mao<tianmao818@qq.com>
 */
public class BeiBao_all {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int N=sc.nextInt();
            //容量
            int W=sc.nextInt();
            //代价
            int[] w=new int[N];
            //价值
            int[] v=new int[N];
            for(int i=0;i<N;i++){
                w[i]=sc.nextInt();
                v[i]=sc.nextInt();
            }

            int[] f=new int[W+1];
            for (int i=0;i<N;i++){
                for(int j=w[i]; j<=W;j++){
                    f[j]=Math.max(f[j],f[j-w[i]]+v[i]);
                }
            }

            Arrays.sort(f);
            System.out.println(f[W]);
        }
    }

}

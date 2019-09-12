package BiShi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Classname BeiBao_01
 * @Description 有N中类型的商品,每一个有自己的体积w[i],价值v[i],容量是V,求最大的价值W
 * 注意:这是一个01背包问题,每一件商品只有1个,即商品只有放入不放入的区别!
 * @Date 19-6-9 下午7:34
 * @Created by mao<tianmao818@qq.com>
 */
public class BeiBao_01 {
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
                for(int j=W;j>=w[i];j--){
                    //前i个商品对应不同容器的最大价值
                    f[j]=Math.max(f[j],f[j-w[i]]+v[i]);
                }
            }
        }
    }
}

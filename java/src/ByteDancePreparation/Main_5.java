package ByteDancePreparation;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author MaoTian
 * @Classname Main_5
 * @Description TODO
 * @Date 下午5:36 2019/9/15
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class Main_5 {


    public static void main(String[] args)throws Exception {
        Scanner sc =new Scanner(new File("/home/mao/workspace/面试/JavaGuide/JavaInterview/java/src/ByteDancePreparation/main_3"));
        //Scanner sc =new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            List<Integer> d=new ArrayList<>();
            List<List<Integer>> dp=new ArrayList<>(n+1);
            for (int i=0;i<n+1;i++){
                dp.add(new ArrayList<>());
            }
            for (int i = 1; i <=n ; i++) {
                d.add(sc.nextInt());
            }

            for (int i = 1; i <=n ; i++) {
                dp.get(i).set(i,d.get(i-1));
            }

            for (int e=1;e<=n;e++){
                for(int s=e-1;s>=1;s--){
                    if(e-s==1){
                        dp.get(s).set(e,Math.max(d.get(s-1),d.get(e-1)));
                    }else {
                        dp.get(s).set(e,Math.max(d.get(s-1)+Math.min(dp.get(s+2).get(e),dp.get(s+1).get(e-1)),d.get(e-1)+Math.min(dp.get(s).get(e-2),dp.get(s+1).get(e-1))));
                    }
                }
            }
            System.out.println(dp.get(1).get(n));
        }
    }
}

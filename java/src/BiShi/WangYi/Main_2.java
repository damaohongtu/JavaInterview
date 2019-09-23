package BiShi.WangYi;

import java.io.File;
import java.util.Scanner;

/**
 * @Author MaoTian
 * @Classname Main_2
 * @Description TODO
 * @Date 下午4:24 2019/9/21
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class Main_2 {
    public static void main(String[] args)throws Exception {
        Scanner sc =new Scanner(new File("/home/mao/workspace/专业/JavaGuide/JavaInterview/java/src/BiShi/WangYi/main_2"));
        //Scanner sc =new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            for (int m = 0; m <n ; m++) {
                int a=sc.nextInt();
                int b=sc.nextInt();
                int c=sc.nextInt();
                int res=Integer.MAX_VALUE;
                for (int i = 0; i <=a ; i++) {
                    for (int j = 0; j <=b ; j++) {
                        for (int k = 0; k <=c ; k++) {
                            int tmp=Math.max(i+b-j,j+c-k);
                            res=Math.min(res,Integer.max(tmp,a-i+k));
                        }
                    }
                }
                System.out.println(res);
            }
        }
    }
}

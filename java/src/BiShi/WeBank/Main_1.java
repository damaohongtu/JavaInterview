package BiShi.WeBank;

import java.io.File;
import java.util.Scanner;

/**
 * @Author MaoTian
 * @Classname Main_1
 * @Description TODO
 * @Date 下午4:32 2019/9/19
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class Main_1 {
    public static int helper(int n){
        int res=1;
        for (int i = 1; i <=n ; i++) {
            res*=i;
            while (res%10==0){
                res=res/10;
            }
            res=res%10;
        }
        return res;
    }
    public static void main(String[] args)throws Exception {
        Scanner sc =new Scanner(new File("/home/mao/workspace/面试/JavaGuide/JavaInterview/java/src/BiShi/WeBank/main_1"));
        //Scanner sc =new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            System.out.println(helper(n));
        }
    }
}

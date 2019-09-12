package BiShi.BZ;

import java.io.File;
import java.util.Scanner;

/**
 * @Author MaoTian
 * @Classname BZ_2
 * @Description TODO
 * @Date 下午6:24 2019/9/10
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class BZ_2 {


    public static int getCount(int N){
        if(N<=2){
            return 1;
        }
        int count=0;
        for (int i = 1; i < N; i++) {
            int s=i*(i+1)/2;
            if(s>N){
                break;
            }else if(s==N) {
                count++;
                break;
            }else {
                if((N-s)%i==0){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args)throws Exception {
        Scanner sc =new Scanner(new File("/home/mao/workspace/java/src/BiShi/BZ/test2"));
        //Scanner sc =new Scanner(System.in);
        while(sc.hasNext()){
            int N=sc.nextInt();
            System.out.println(getCount(N));
        }
    }
}

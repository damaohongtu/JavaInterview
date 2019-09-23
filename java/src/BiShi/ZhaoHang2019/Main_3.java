package BiShi.ZhaoHang2019;

import java.io.File;
import java.util.Scanner;

/**
 * @Author MaoTian
 * @Classname Main_3
 * @Description TODO
 * @Date 上午11:40 2019/9/14
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class Main_3 {
    public static int getMaxMulti(int N){

        int[] tmp=new int[N+1];
        if(N<=4){
            return N;
        }
        tmp[0]=1;
        tmp[1]=1;
        tmp[2]=2;
        tmp[3]=3;
        tmp[4]=4;
        tmp[5]=5;
        for(int i=5;i<=N;i++){
            tmp[i]=Math.max(tmp[i-3]*3,Math.max(tmp[i-4]*4,tmp[i-5]*6));
        }
        return tmp[N];
    }
    public static void main(String[] args)throws Exception {
        Scanner sc =new Scanner(new File("/home/mao/workspace/面试/JavaGuide/JavaInterview/java/src/BiShi/ZhaoHang2019/main_3"));
        //Scanner sc =new Scanner(System.in);
        while(sc.hasNext()){
            int N=sc.nextInt();
            System.out.println(getMaxMulti(N));
        }
    }
}

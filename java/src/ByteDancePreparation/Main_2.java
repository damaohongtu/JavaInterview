package ByteDancePreparation;


import java.io.File;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main_2 {
    public static void main(String[] args)throws Exception {
        Scanner sc =new Scanner(new File("/home/mao/workspace/面试/JavaGuide/JavaInterview/java/src/ByteDancePreparation/main_2"));
        //Scanner sc =new Scanner(System.in);
        while(sc.hasNext()){
            //res记录没有处理的最大值
            long n,t,c,last_t=0,left=0,res=0;
            n=sc.nextLong();
            for (long i=1;i<=n;i++){
                //到达时间
                t=sc.nextLong();
                //数量
                c=sc.nextLong();

                long tmp=left-(t-last_t);
                if(tmp<0){
                    tmp=0;
                }

                //剩余没有处理
                left=c+tmp;
                if(left>res){
                    res=left;
                }
                last_t=t;
            }
            //最后到达时间加上没有处理的
            System.out.println(last_t+left+" "+res);
        }

        LinkedHashMap<String,Integer>tmp;
    }
}

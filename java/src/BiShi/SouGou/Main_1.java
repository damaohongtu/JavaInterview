package BiShi.SouGou;

import java.io.File;
import java.util.Scanner;

/**
 * @Author MaoTian
 * @Classname Main_1
 * @Description TODO
 * @Date 下午7:21 2019/9/16
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class Main_1 {

    public static void main(String[] args)throws Exception {

        Scanner sc =new Scanner(new File("/home/mao/workspace/面试/JavaGuide/JavaInterview/java/src/BiShi/SouGou/main_1"));
        //Scanner sc =new Scanner(System.in);
        while(sc.hasNext()){
            int N=Integer.parseInt(sc.next());
            int M=Integer.parseInt(sc.next());
            String[] rule=new String[N];
            String[] ip=new String[M];
            for (int i=0;i<N;i++){
                rule[i]=sc.next();
            }
            for (int j = 0; j <M ; j++) {
                ip[j]=sc.next();
            }

            int[] res=new int[M];
            for(int j=0;j<M;j++){
                int flag=0;

                for (int i = 0; i <N ; i++) {

                    if(ip[j].equals(rule[i])){
                        flag=1;
                        break;
                    }

                    if(rule[i].startsWith("*")){
                        String t11=rule[i].substring(2,rule[i].length());

                        int len=ip[j].length();
                        int len1=t11.length();

                        String t12=ip[j].substring(len-len1,ip[j].length());
                        if(t11.equals(t12)){
                            flag=1;
                            break;
                        }
                    }
                    if (rule[i].endsWith("*")){

                        String t11=rule[i].substring(0,rule[i].length()-2);
                        int len1=t11.length();
                        String t12=ip[j].substring(0,len1);
                        if(t11.equals(t12)){
                            flag=1;
                            break;
                        }
                    }


                }
                res[j]=flag;
            }

            for (int i = 0; i <M ; i++) {
                System.out.print(res[i]+" ");
            }
        }
    }
}

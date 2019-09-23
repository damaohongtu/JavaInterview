package NiuKeWang.WangNianZhenTI;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @Classname Test_02_HuaWei_01
 * @Description TODO
 * @Date 19-4-9 上午10:50
 * @Created by mao<tianmao818@qq.com>
 */
public class Test_02_HuaWei_01 {
    public static void main(String[] args)throws IOException {

        Scanner sc = new Scanner(new File("/home/mao/workspace/java/src/WangNianZhenTI/test"));
        int M=0,N=0;
        int i;
        int A=0,B=0;
        while(sc.hasNext()){
            N=sc.nextInt();
            M=sc.nextInt();
            int[] score=new int[N];
            for(i=0;sc.hasNext()&&i<N;i++){
                score[i]=sc.nextInt();
            }
            String c=null;
            for(i=0;sc.hasNext()&& i<M;i++){
                c=sc.next();
                A=sc.nextInt();
                B=sc.nextInt();
                process(c,A,B,score);
            }
        }

    }
    private static void process(String c, int a, int b, int[] score) {
        int begin,end;

        if(c.equals("Q")){
            end = Math.max(a, b);
            begin = Math.min(a, b)-1;
            int max = score[begin];
            for(int i=begin;i<end;i++){
                if(max<score[i]){
                    max = score[i];
                }
            }
            System.out.println(max);
        }else if(c.equals("U")){
            score[a-1] = b;
        }
    }
}
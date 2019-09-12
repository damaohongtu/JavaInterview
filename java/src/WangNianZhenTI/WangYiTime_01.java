package WangNianZhenTI;

import java.io.File;
import java.util.Scanner;

public class WangYiTime_01 {
    public static void main(String[] args)throws Exception {
        Scanner sc=new Scanner(new File("/home/mao/workspace/java/src/WangNianZhenTI/test"));
        while (sc.hasNext()){
            int n=sc.nextInt();
            for(int i=0;i<n;i++){
                String ans="";
                String s=sc.next();
                String[] time=s.split(":");
                int h1=time[0].charAt(0)-'0';
                int h2=time[0].charAt(1)-'0';
                int m1=time[1].charAt(0)-'0';
                int m2=time[1].charAt(1)-'0';
                int s1=time[2].charAt(0)-'0';
                int s2=time[2].charAt(1)-'0';
                if(h1==2&&h2>=4||h1>2){
                    h1=0;
                }
                if(m1>5){
                    m1=0;
                }
                if(s1>5){
                    s1=0;
                }
                ans=""+h1+""+h2+":"+m1+""+m2+":"+s1+""+s2;

                System.out.println(ans);
            }
        }


    }
}

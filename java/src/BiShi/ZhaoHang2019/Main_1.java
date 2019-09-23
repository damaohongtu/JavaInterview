package BiShi.ZhaoHang2019;

import java.io.File;
import java.util.Scanner;

/**
 * @Author MaoTian
 * @Classname Main_1
 * @Description TODO
 * @Date 上午11:24 2019/9/14
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class Main_1 {
    public static boolean check(String s,String s1){
        String tmp=s1;
        while (tmp.length()<s.length()){
            tmp=tmp+s1;
        }
        if(s.equals(tmp)){
            return true;
        }
        return false;
    }
    public static void main(String[] args)throws Exception {
        Scanner sc =new Scanner(new File("/home/mao/workspace/面试/JavaGuide/JavaInterview/java/src/BiShi/ZhaoHang2019/main_1"));
        //Scanner sc =new Scanner(System.in);
        while(sc.hasNext()){
            String s=sc.nextLine();
            int len=s.length();
            boolean flag=false;
            for(int i=1;i<=len/2;i++){
                String tmp=s.substring(0,i);
                if(check(s,tmp)){
                    System.out.println(tmp);
                    flag=true;
                    break;
                }
            }
            if(flag==false){
                System.out.println("false");
            }
        }
    }
}

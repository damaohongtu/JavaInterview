package BiShi;

import java.util.Scanner;

/**
 * @Classname Shopee_03
 * @Description TODO
 * @Date 19-7-27 下午6:53
 * @Created by mao<tianmao818@qq.com>
 */

public class Shopee_03 {

    public static boolean divide(String s,String d){

        String tmp=d;
        String dd=d;
        int len=dd.length();

        while (len<=s.length()){
            if(s.equals(dd)){
                return true;
            }
            dd=dd+tmp;
            len=dd.length();
        }
        return false;
    }


    public static String common(String s1,String s2){

        String res="";
        for(int i=0;i<s1.length();i++){

            String d=s1.substring(0,i+1);

            if(divide(s1,d)&&divide(s2,d)){
                res=d;
            }
        }
        return res;

    }

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){

            String s1=sc.next();
            String s2=sc.next();
            String res=common(s1,s2);
            System.out.println(res);

        }
    }

}

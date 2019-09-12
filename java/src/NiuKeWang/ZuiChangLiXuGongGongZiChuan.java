package NiuKeWang;

import java.util.Scanner;

/**
 * @Classname ZuiChangLiXuGongGongZiChuan
 * @Description 直接使用暴力求解的方法,一小段一小段进行寻找!
 * @Date 19-6-1 下午4:15
 * @Created by mao<tianmao818@qq.com>
 */
public class ZuiChangLiXuGongGongZiChuan {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String s1=sc.nextLine();
            String s2=sc.nextLine();
            int ans=0;

            for(int i=0;i<s1.length();i++){
                for(int j=i;j<s1.length();j++){
                    String tmp=s1.substring(i,j+1);
                    if(s2.indexOf(tmp)>-1){
                        ans= Math.max(ans,tmp.length());
                    }
                }
            }

            System.out.println(ans);
        }
    }
}

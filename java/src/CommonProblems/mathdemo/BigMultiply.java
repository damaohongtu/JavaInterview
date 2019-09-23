package CommonProblems.mathdemo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Classname BigMultiply
 * @Description 大数乘法
 * @Date 19-7-26 上午10:23
 * @Created by mao<tianmao818@qq.com>
 */

public class BigMultiply {
    public static String add(String s1,String s2){
        int len1=s1.length();
        int len2=s2.length();
        int pad=Math.abs(len1-len2);
        String padding="";
        for(int i=0;i<pad;i++){
            padding=padding+"0";
        }
        if(len1>len2){
            s2=padding+s2;
        }else{
            s1=padding+s1;
        }
        int len=s1.length();

        String ans="";
        int c=0;
        for(int j=len-1;j>=0;j--){
            int a=s1.charAt(j)-'0';
            int b=s2.charAt(j)-'0';
            int v=(a+b+c)%10;
            c=(a+b+c)/10;
            ans=v+ans;
        }
        if(c>0){
            ans=c+ans;
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String s1=sc.next();
            String s2=sc.next();
            System.out.println(add(s1,s2));
            int len2=s2.length();
            ArrayList<String> tmp=new ArrayList<>();
            for(int i=len2-1;i>=0;i--){
                String ans="";
                int v=s2.charAt(i)-'0';
                for(int j=0;j<v;j++){
                    ans=add(ans,s1);
                }
                int pad=len2-1-i;
                String padding="";
                for(int l=0;l<pad;l++){
                    padding=padding+"0";
                }
                ans=ans+padding;
                tmp.add(ans);
            }
            String result="";
            for(String s:tmp){
                result=add(result,s);
            }
            System.out.println(result);
        }
    }
}

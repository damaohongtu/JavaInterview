package NiuKeWang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Classname BigNumMultiply
 * @Description TODO
 * @Date 19-3-16 下午4:18
 * @Created by mao<tianmao818@qq.com>
 */
public class BigNumOperate {
    public String multiply(String str1,String str2){
        int len1=str1.length();
        int len2=str2.length();
        String[] offset=new String[len2];
        String off="";
        for(int i=len2-1;i>=0;i--){
            offset[i]=off;
            off=off+"0";
        }
        String[] num=new String[len2];
        String tmp="";
        int num1=0;
        int num2=0;
        int carry=0;
        for(int i=len2-1;i>=0;i--){
            for(int j=len1-1;j>=0;j--){
                num1=str1.charAt(j)-'0';
                num2=str2.charAt(i)-'0';
                int value=(num1*num2+carry)%10;
                carry=(num1*num2+carry)/10;
                tmp=value+tmp;
            }
            if(carry>0){
                tmp=carry+tmp;
            }
            carry=0;
            num[i]=tmp+offset[i];
            tmp="";
        }
        for(int i=len2-1;i>=0;i--){
            System.out.println(num[i]);
        }
        String res=num[len2-1];
        for (int i=len2-2;i>=0;i--){
            res=add(res,num[i]);
        }
        return res;
    }
    public String add(String str1,String str2){
        int num1=0;
        int num2=0;
        int carry=0;
        int i=str1.length()-1;
        int j=str2.length()-1;
        String res="";
        while(i>=0 && j>=0){
            num1=str1.charAt(i)-'0';
            num2=str2.charAt(j)-'0';
            int num=(num1+num2+carry)%10;
            carry=(num1+num2+carry)/10;
            i--;
            j--;
            res=num+res;
        }

        while(i>=0){
            num1=str1.charAt(i)-'0';
            int num=(num1+carry)%10;
            carry=(num1+carry)/10;
            i--;
            res=num+res;
        }

        while(j>=0){
            num2=str2.charAt(j)-'0';
            int num=(num2+carry)%10;
            carry=(num2+carry)/10;
            j--;
            res=num+res;
        }
        if(carry==1){
            res=1+res;
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BigNumOperate bigNumOperate=new BigNumOperate();
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(ir);
        String[] str = bf.readLine().split(" ");
        BigNumOperate bigNumOperate1=new BigNumOperate();
        System.out.println(bigNumOperate.multiply(str[0],str[1]));
    }
}
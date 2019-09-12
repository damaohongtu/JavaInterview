package WangNianZhenTI;

import java.util.Scanner;

/**
 * @Classname Test_01_HuaWei
 * @Description TODO
 * @Date 19-4-3 下午10:39
 * @Created by mao<tianmao818@qq.com>
 */
public class Test_01_HuaWei {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int len=s.length();
        int result=0;
        int curr=0;
        for(int i=len-1;i>=2;i--){
            char chr=s.charAt(i);
            int tmp=0;
            if(chr>='0' && chr<='9'){
                tmp=chr-'0';
            }
            if(chr>='A' && chr<='F'){
                tmp=chr-'A'+10;
            }
            result+=(tmp*Math.pow(16,curr));
            curr++;
        }
        System.out.println(result+"");
    }
}
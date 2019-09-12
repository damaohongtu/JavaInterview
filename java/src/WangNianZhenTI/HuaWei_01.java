package WangNianZhenTI;

import java.util.Scanner;

/**
 * @Classname HuaWei_01
 * @Description TODO
 * @Date 19-7-12 下午1:29
 * @Created by mao<tianmao818@qq.com>
 */

public class HuaWei_01 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String s=sc.nextLine();
            s=s.toLowerCase();
            int[] ans=new int[26];
            String res="";
            for(int i=0;i<s.length();i++){
                char c=s.charAt(i);
                if(ans[c-'a']==0){
                    res=res+c;
                    ans[c-'a']=1;
                }
            }
            System.out.println(res);
        }
    }
}

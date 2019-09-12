package NiuKeWang;

import java.util.Scanner;

/**
 * @Classname HuiWenSuoYin
 * @Description 输出回文索引
 * @Date 19-6-1 上午9:50
 * @Created by mao<tianmao818@qq.com>
 */
public class HuiWenSuoYin {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            for(int i=0;i<n;i++){
                String s=sc.next();
                if(helper(s)){
                    System.out.println(-1);
                }else{
                    for(int j=0;j<s.length();j++){
                        String tmp=s.substring(0,j)+s.substring(j+1);
                        if(helper(tmp)){
                            System.out.println(j);
                            break;
                        }
                    }
                }

            }
        }
    }
    public static boolean helper(String s){
        String tmp=new StringBuffer(s).reverse().toString();
        if(s.equals(tmp)){
            return true;
        }
        return false;
    }
}

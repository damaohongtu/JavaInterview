package NiuKeWang;

import java.util.Scanner;

/**
 * @Classname DaFuWeng
 * @Description TODO
 * @Date 19-6-1 上午11:18
 * @Created by mao<tianmao818@qq.com>
 */
public class DaFuWeng {
     public static void main(String[] args){
         Scanner sc=new Scanner(System.in);
         while (sc.hasNext()){
             int n=sc.nextInt();
             int[] tmp={1,2,4,8,16,32};
             System.out.println(tmp[n-1]);
         }
     }
}

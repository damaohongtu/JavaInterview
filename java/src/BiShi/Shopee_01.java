package BiShi;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Classname Shopee_01
 * @Description TODO
 * @Date 19-7-27 下午6:52
 * @Created by mao<tianmao818@qq.com>
 */

public class Shopee_01 {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        while(sc.hasNextLine()){
            String s=sc.nextLine();
            String[] nums=s.split(" ");
            HashMap<String,Integer> tmp=new HashMap<>();
            String res="";
            for(String t:nums){
                if(!tmp.containsKey(t)){
                    tmp.put(t,1);
                    res=res+t+" ";
                }

            }
            System.out.println(res);
        }
    }

}

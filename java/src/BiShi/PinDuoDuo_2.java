package BiShi;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @Classname PinDuoDuo_2
 * @Description TODO
 * @Date 19-7-28 下午1:48
 * @Created by mao<tianmao818@qq.com>
 */

public class PinDuoDuo_2 {

    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(new File("/home/mao/workspace/java/src/BiShi/pinduoduo2"));
        while (sc.hasNext()){
            String t=sc.nextLine();
            String[] v=t.split(" ");

            HashMap<Character,Character> dict=new HashMap<>();
            Character start=v[0].charAt(0);
            Character over=v[0].charAt(0);
            for(String s:v){
                Character c1=s.charAt(0);
                Character c2=s.charAt(s.length()-1);
                dict.put(c1,c2);
            }
            Character end=null;
            for(int i=0;i<v.length;i++){
                end=dict.get(start);
                start=end;
            }
            if(over==end){
                System.out.println(true);
            }else {
                System.out.println(false);
            }

        }
    }
}

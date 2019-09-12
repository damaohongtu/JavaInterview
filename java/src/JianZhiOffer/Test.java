package JianZhiOffer;

import java.util.*;

/**
 * @Classname Test
 * @Description TODO
 * @Date 19-3-10 下午7:35
 * @Created by mao<tianmao818@qq.com>
 */
public class Test {
    public static void main(String[] args){

        String s="dadfadf  adfasd adfadf adfad adfad";
        s=s.trim();
        String[] mao=s.split("\\s+");
        System.out.println(mao);
        for (int i=0;i<mao.length;i++){
            System.out.println(mao[i]);
        }
        ArrayList<Integer> yun=new ArrayList<>();
        String test="lingyun&mao520FOREVER";
        LinkedHashMap<Character,Integer> yun1=new LinkedHashMap<>();
        yun1.put('c',yun.get('c')+1);
        for (Map.Entry<Character, Integer> entry : yun1.entrySet()){

        }
        Collections.reverse(yun);
        System.out.println(Integer.parseInt("520")+1314);
        System.out.println(Character.digit('9',10));
        System.out.println('A'+0);
        System.out.println('Z'+0);
        System.out.println('a'+0);
        System.out.println('z'+0);

    }

}
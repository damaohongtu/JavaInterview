package JianZhiOffer;

import java.util.Scanner;

/**
 * @Classname offer_04
 * @Description 请实现一个函数，把字符串中的每个空格替换成"%20"
 * @Date 19-4-22 上午9:58
 * @Created by mao<tianmao818@qq.com>
 */
public class offer_04 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextLine()){

            StringBuffer s=new StringBuffer(sc.nextLine());
            System.out.print(helper(s));
        }
    }
    public static String helper(StringBuffer str){
        int length=str.length();
        int indexOfOrigin=length-1;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                length+=2;
            }
        }
        str.setLength(length);
        int indexOfNew=length-1;
        while(indexOfNew>indexOfOrigin){//并没有建立新的StringBuffer,所以不要存在"="
            if(str.charAt(indexOfOrigin)!=' '){
                str.setCharAt(indexOfNew--,str.charAt(indexOfOrigin));
            }else{
                str.setCharAt(indexOfNew--,'%');
                str.setCharAt(indexOfNew--,'2');
                str.setCharAt(indexOfNew--,'0');
            }
            indexOfOrigin--;
        }


        return str.toString();
    }
}
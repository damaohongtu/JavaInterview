package BiShi;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @Classname Test_02_HuaWei_01
 * @Description TODO
 * @Date 19-4-10 下午6:49
 * @Created by mao<tianmao818@qq.com>
 */
public class Test_02_HuaWei_01 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("/home/mao/workspace/java/src/ProgrammingTest/test1"));
        int n=0;
        ArrayList<String> tmp=new ArrayList<>();
        while(sc.hasNext()){
            n=sc.nextInt();
            for(int i=0;i<n;i++){
                String s=sc.next();
                if(s.length()>0){
                    int index=0;
                    for(int len=s.length();len>8;len=len-8){
                        String ss=s.subSequence(0,8).toString();
                        tmp.add(ss);
                        index=index+8;
                    }
                    if(index<s.length()){
                        String ss=s.subSequence(index,s.length()).toString();
                        ss=helper(ss);
                        tmp.add(ss);
                    }
                }

            }

            Collections.sort(tmp);
            for(String s:tmp){
                System.out.print(s+" ");
            }
            tmp.clear();
        }
    }
    public static String helper(String s){
        String res=s;

        for(int i=0;i<(8-s.length());i++){
            res+="0";
        }

        return res;
    }
}
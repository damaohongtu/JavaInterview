package BiShi;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Classname Test_01_HuaWei_01
 * @Description TODO
 * @Date 19-4-3 下午5:04
 * @Created by mao<tianmao818@qq.com>
 */
public class Test_01_HuaWei_01 {
    public static void main(String[] args)throws IOException {

//        Scanner sc2=new Scanner(System.in);
        Scanner sc2=new Scanner(new File("/home/mao/workspace/java/src/ProgrammingTest/test"));

        int len=0;
        int flag=0;
        ArrayList<String> s=new ArrayList<>();
        while(sc2.hasNextLine()){

            String tmp=sc2.nextLine();

            if(tmp.isEmpty()){
                break;
            }
            if(flag==0){
                len=Integer.parseInt(tmp);
                flag=1;
            }else{
                s.add(tmp);
            }

        }
        if(len==0){
            return;
        }

        ArrayList<ArrayList<Integer>> nums=new ArrayList<>();

        for(int i=0;i<s.size();i++){
            String[] ss=s.get(i).split(",");
            ArrayList<Integer> num=new ArrayList<>();
            for (String sss:ss){
                num.add(Integer.parseInt(sss));
            }
            nums.add(num);
        }
        if(nums.size()==0){
            return;
        }
        ArrayList<Integer> outcome=new ArrayList<>();

        while(nums.size()!=0){
            for(int k=0;k<nums.size();k++){

                int a=nums.get(k).size();
                if(a==0){
                    nums.remove(k);
                } else if(a>=len){
                    for(int n=0;n<len;n++){
                        outcome.add(nums.get(k).get(0));
                        nums.get(k).remove(0);
                    }
                }else{
                    for(int n=0;n<a;n++){
                        outcome.add(nums.get(k).get(0));
                        nums.get(k).remove(0);
                    }
                }
            }
        }
        for(int l=0;l<outcome.size()-1;l++){
            System.out.print(outcome.get(l)+",");
        }
        System.out.print(outcome.get(outcome.size()-1));
    }
}
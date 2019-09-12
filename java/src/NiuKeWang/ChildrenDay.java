package NiuKeWang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @Classname ChildrenDay
 * @Description TODO
 * @Date 19-3-17 上午10:05
 * @Created by mao<tianmao818@qq.com>
 */
public class ChildrenDay {
    public static void main(String[] args)throws IOException {
        InputStreamReader ir=new InputStreamReader(System.in);
        BufferedReader bf=new BufferedReader(ir);
        int n = Integer.parseInt(bf.readLine());
        String[] children = bf.readLine().split(" ");
        int m=Integer.parseInt(bf.readLine());
        String[] chocolate=bf.readLine().split(" ");
        int [] children1=new int[children.length];
        int [] chocolate1=new int[chocolate.length];
        for(int i=0;i<children.length;i++){
            children1[i]=Integer.parseInt(children[i]);
        }
        for(int j=0;j<chocolate.length;j++){
            chocolate1[j]=Integer.parseInt(chocolate[j]);
        }
        Arrays.sort(children1);
        Arrays.sort(chocolate1);
        int i=0,j=0;
        int count=0;
        String s="";
        while (i<children1.length && j<chocolate1.length){
            if(children1[i]<=chocolate1[j]){
                count++;
                i++;
                j++;
            }
            if(children1[i]>chocolate1[j]){
                j++;
            }
        }
        System.out.println(count);
    }
}
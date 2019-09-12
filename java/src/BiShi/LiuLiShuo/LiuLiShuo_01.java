package BiShi.LiuLiShuo;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @Author MaoTian
 * @Classname LiuLiShuo_01
 * @Description TODO
 * @Date 下午6:20 2019/8/19
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
class Node{
    int a;
    int b;
    public Node(int a,int b){
        this.a=a;
        this.b=b;
    }
}
public class LiuLiShuo_01 {
    public static void main(String[] args)throws Exception {
        Scanner sc =new Scanner(new File("/home/mao/workspace/java/src/BiShi/LiuLiShuo/test1"));
        //Scanner sc =new Scanner(System.in);
        while(sc.hasNext()){
            String s1=sc.nextLine();
            String s2=sc.nextLine();
            String[] arr1=s1.split(" ");
            String[] arr2=s2.split(" ");
            int[] arr11=new int[arr1.length];
            int[] arr22=new int[arr2.length];

            for (int i = 0; i < arr11.length; i++) {
                arr11[i]=Integer.parseInt(arr1[i]);
            }
            for (int i = 0; i < arr11.length; i++) {
                arr22[i]=Integer.parseInt(arr2[i]);
            }

            ArrayList<Node> time=new ArrayList<>();
            for(int i=0;i<arr1.length;i++){
                time.add(new Node(arr11[i],arr22[i]));
            }
            Collections.sort(time,(a,b)->(a.a-b.a));
            int[] res=new int[arr1.length];
            for(int i=0;i<arr1.length;i++){
                res[i]=1;
            }
            for(int i=1;i<arr1.length;i++){
                for(int j=0;j<i;j++){
                    if(time.get(j).b>time.get(i).a){
                        res[i]++;
                    }
                }
            }
            int ans=0;
            for (int i = 0; i < arr1.length; i++) {
                if(res[i]>ans){
                    ans=res[i];
                }
            }
            System.out.println(ans);

        }
    }
}

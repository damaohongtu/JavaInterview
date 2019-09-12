package WangNianZhenTI;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WangYI_xiaoxi_02 {
    public static void main(String[] args)throws Exception {
        Scanner sc=new Scanner(new File("/home/mao/workspace/java/src/WangNianZhenTI/test"));
        int count=sc.nextInt();
        for (int i = 0; i <count ; i++) {
            List<Integer>tmp=new ArrayList<>();
            int n=sc.nextInt();
            for(int j=0;j<n;j++){
                int num=sc.nextInt();
                int index=tmp.indexOf(num);
                if(index>=0){
                    tmp.remove(index);
                    tmp.add(num);
                }else{
                    tmp.add(num);
                }
            }
            String ans="";
            for(int j=tmp.size()-1;j>=0;j--){
                ans=ans+tmp.get(j)+" ";
            }
            System.out.println(ans);
        }
    }
}

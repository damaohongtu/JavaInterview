package BiShi;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author MaoTian
 * @Classname Zoom
 * @Description TODO
 * @Date 下午2:28 2019/8/17
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class Zoom {
    public static void main(String[] args)throws Exception {
        Scanner sc =new Scanner(new File("/home/mao/workspace/java/src/BiShi/test"));
        //Scanner sc =new Scanner(System.in);
        while(sc.hasNext()){
            String s=sc.next();
            char[] arr=s.toCharArray();
            int count=0;
            int num=0;
            ArrayList<Integer> res=new ArrayList<>();
            for(int i=0;i<arr.length;i++){
                if (Character.isDigit(arr[i])){
                    num=num*10+arr[i]-'0';
                    continue;
                }
                if (Character.isLetter(arr[i])||arr[i]=='.'){
                    if(count%2!=0){
                        num=0-num;
                    }
                    res.add(num);
                    num=0;
                    count=0;
                    continue;
                }
               else if (arr[i]=='-'){
                    count++;
                    continue;
                }

            }

            if(count%2!=0){
                num=0-num;
            }
            res.add(num);
            int ans=0;
            for (Integer i:res){
                ans+=i;
            }
            if(res.isEmpty()){
                System.out.println(0);
            }else{
                System.out.println(ans);
            }

        }
    }
}

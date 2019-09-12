package NiuKeWang;

import java.util.Scanner;

/**
 * @Classname ZuiXiaoDaiJiaLouTi
 * @Description 每一个路径都有权重,一次只能跳一部或者两步
 * @Date 19-5-29 下午8:46
 * @Created by mao<tianmao818@qq.com>
 */
public class ZuiXiaoDaiJiaLouTi {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String s=sc.next();
            String[] nums=s.split(",");

            int len =nums.length;
            if(len ==0){
                System.out.println(0);
                return;
            }
            int[] path=new int[len];
            for(int i=0;i<len;i++){
                path[i]=Integer.parseInt(nums[i]);
            }
            if(len<3){
                if(len<2){
                    System.out.println(0);
                }else {
                    System.out.println(path[0]+path[1]);
                }
                return;
            }
            int[] ans= new int[len];
            ans[0]=path[0];
            ans[1]=path[1];
            for(int i=2;i<len;i++){
                ans[i]=Math.min(ans[i-1]+path[i],ans[i-2]+path[i]);
            }
            System.out.println(ans[len-1]);

        }
    }
}

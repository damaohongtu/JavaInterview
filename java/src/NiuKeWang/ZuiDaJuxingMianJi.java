package NiuKeWang;

import java.util.Scanner;

/**
 * @Classname ZuiDaJuxingMianJi
 * @Description TODO
 * @Date 19-6-1 下午4:05
 * @Created by mao<tianmao818@qq.com>
 */
public class ZuiDaJuxingMianJi {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int[] heights=new int[n];
            for(int i=0;i<n;i++){
                heights[i]=sc.nextInt();
            }

            int ans=0;
            for(int i=0;i<n;i++){

                //避免重复计算,当然没有这一段也ok
                if(i+1<n && heights[i]<heights[i+1]){
                    continue;
                }

                int minH=heights[i];

                for(int j=i;j>=0;j--){
                    minH=Math.min(minH,heights[j]);
                    ans=Math.max(ans,minH*(i-j+1));
                }
            }
            System.out.println(ans);
        }
    }
}

package BiShi;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @Classname ZiJieTiaoDong
 * @Description TODO
 * @Date 19-7-17 下午7:25
 * @Created by mao<tianmao818@qq.com>
 */


public class ZiJieTiaoDong{
    public static int getMax(int[] prices,int day1,int day2){

        if(day1>=day2){
            return 0;
        }
        int min=prices[day1];

        Integer [] ans=new Integer[day2-day1+1];

        for(int i=day1;i<=day2;i++){
            ans[i-day1]=prices[i-day1]-min;

            if(min>prices[i-day1]){
                min=prices[i-day1];
            }
        }
        System.out.println(Collections.max(Arrays.asList(ans)));

        return Collections.max(Arrays.asList(ans));
    }
    public static void main(String[] args){
        int[] test={1,2,3,4,5,6};
        int len=6;
        int res=0;
        for(int i=0;i<len;i++){
            int first=getMax(test,0,i);
            int second=getMax(test,i+1,len-1);
            res=res>(first+second)?res:(first+second);

        }
        System.out.println(res);
    }
}

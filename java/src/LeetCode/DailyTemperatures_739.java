package LeetCode;

import java.util.Stack;

/**
 * @Classname DailyTemperatures_739
 * @Description 还需要多少天温度才能够增加?暴力ac!!!
 * @Date 19-5-13 下午8:59
 * @Created by mao<tianmao818@qq.com>
 */
public class DailyTemperatures_739 {
    public int[] dailyTemperatures(int[] T) {
        int len=T.length;
        int[] result=new int[len];
        int count=1;
        int flag=0;
        for(int i=0;i<len-1;i++){
            for(int j=i+1;j<len;j++){
                if(T[i]>=T[j]){
                    count++;
                }else{
                    flag=1;
                    break;
                }
            }
            if(flag==1){
                result[i]=count;
            }else {
                result[i]=0;
            }
            count=1;
            flag=0;
        }
        return result;
    }
    public int[] dailyTemperatures_2(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        //保存结果,初始全0
        int[] ret = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++) {

            //在当前的栈不空的情况下,进行比较!而且这里使用的是for循环,比如来了一个非常大的值,在栈不为空的情况下会一直进行计算的!!!!
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                //计算出位置差
                ret[idx] = i - idx;
            }
            //注意:栈中存放的数据是降序的,小于等于的时候才push
            stack.push(i);
        }
        return ret;
    }
}

package LeetCode;

import java.util.*;

/**
 * @Classname TaskScheduler_621
 * @Description 同一种任务之间必须间隔n秒,求出最少需要的时间,中间间隔不够的使用哑间隔进行填充!
 * @Date 19-5-14 下午9:15
 * @Created by mao<tianmao818@qq.com>
 */
public class TaskScheduler_621 {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> count=new HashMap<>();
        for(int i=0;i<tasks.length;i++){
            if(count.containsKey(tasks[i])){
                int value=count.get(tasks[i])+1;
                count.put(tasks[i],value);
            }else{
                count.put(tasks[i],1);
            }
        }
        int len=count.size();

        ArrayList<Integer> result=new ArrayList<>();
        for(Character key:count.keySet()){
            result.add(count.get(key));
        }
        Collections.sort(result);
        int a=1;
        int b=result.get(len-1);
        for(int j=len-2;j>=0;j--){
            if(result.get(j)==b){
                a++;
            }else {
                break;
            }
        }
        return a*b+(n-b+1)*(a-1);
    }
}

package LeetCode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Classname DistributeCandies_575
 * @Description TODO
 * @Date 19-5-30 上午10:42
 * @Created by mao<tianmao818@qq.com>
 */
public class DistributeCandies_575 {
    public int distributeCandies(int[] candies) {

        HashSet<Integer> set = new HashSet<>();
        for(int i:candies){
            set.add(i);
        }

        int a=set.size();
        int b=candies.length/2;
        if(a>b){
            return b;
        }else {
            return a;
        }
    }
}

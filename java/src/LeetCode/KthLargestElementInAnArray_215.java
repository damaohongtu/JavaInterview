package LeetCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Classname KthLargestElementInAnArray_215
 * @Description TODO
 * @Date 19-5-20 下午7:10
 * @Created by mao<tianmao818@qq.com>
 */
public class KthLargestElementInAnArray_215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue=new PriorityQueue<>(nums.length,new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i:nums){
            queue.add(i);
        }
        int ans=0;
        for(int i=0;i<k-1;i++){
            queue.poll();
        }
        ans=queue.peek();
        return ans;
    }
}

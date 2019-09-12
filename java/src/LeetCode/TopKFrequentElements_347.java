package LeetCode;

import java.util.*;

/**
 * @Classname TopKFrequentElements_347
 * @Description 计算频率
 * @Date 19-5-20 下午2:15
 * @Created by mao<tianmao818@qq.com>
 */
public class TopKFrequentElements_347 {

    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        //存放结果
        List<Integer> res = new LinkedList<Integer>();
        //使用堆来求第K大的数字
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<Map.Entry<Integer, Integer>>((a,b)->(b.getValue()-a.getValue()));

        //HashMap拿值
        for(int val : nums) map.put(val, map.getOrDefault(val, 0) + 1);
        queue.addAll(map.entrySet());
        for(int i = 0;i < k;i++) res.add(queue.poll().getKey());
        return res;
    }
}

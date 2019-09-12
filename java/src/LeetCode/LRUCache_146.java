package LeetCode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Classname LRUCache_146
 * @Description LRU算法的实现,输入一个容器,当超过了移除最近最少使用的,
 * cache.put(1, 1);
 * cache.put(2, 2);
 * 输入的key是任务的名字Map.entity
 *
 * 维护一个队列
 *
 *
 * @Date 19-5-20 下午4:15
 * @Created by mao<tianmao818@qq.com>
 */
public class LRUCache_146 {
    Map<Integer,Integer> map = new LinkedHashMap<>();
    int capacity=0;
    public LRUCache_146(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            int value = map.get(key);
            map.remove(key);
            map.put(key,value);
            return value;
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if(capacity <= 0) return;
        if(map.containsKey(key)){
            map.remove(key);
            map.put(key,value);
            return;
        }
        if(map.size() == capacity){
            Map.Entry<Integer,Integer> entry = map.entrySet().iterator().next();
            if(entry!=null){
                map.remove(entry.getKey());
                map.put(key,value);
            }
        }else{
            map.put(key,value);
        }
    }
}

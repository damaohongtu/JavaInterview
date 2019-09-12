package JavaDemo.CollectionsTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @Author MaoTian
 * @Classname HashMapTraversal
 * @Description HashMap遍历
 * @Date 下午1:48 2019/8/14
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class HashMapTraversal {
    public static void main(String[] args) {
        Map<String,Integer> map=new HashMap<>();
        for(int i=0;i<5;i++){
            map.put("key_"+String.valueOf(i),i);
        }
        for (String key:map.keySet()){
            System.out.println(key+":"+map.get(key));
        }

        System.out.println("-----------------------------------");

        for (Map.Entry<String,Integer> entry:map.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }

        System.out.println("-----------------------------------");

        Set<Map.Entry<String,Integer>> entrySet = map.entrySet();
        for(Map.Entry<String,Integer> entry:entrySet){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }

        System.out.println("-----------------------------------");

        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();//上下相同, 这个清晰一些
        while (it.hasNext()) {
            Map.Entry<String, Integer> tmp=it.next();
            System.out.println(tmp.getKey()+":"+tmp.getValue());
        }

    }
}

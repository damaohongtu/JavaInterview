package LeetCode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Classname KClosestPointstoOrigin
 * @Description TODO
 * @Date 19-2-28 下午4:50
 * @Created by mao<tianmao818@qq.com>
 */
public class KClosestPointstoOrigin {
    public int[][] kClosest(int[][] points, int K) {
        int m=points.length;
        int n=points[0].length;
        int[][] result=new int[K][n];
        HashMap<Integer,Integer> temp=new HashMap<>();
        for(int i=0;i<m;i++){
            int sqrt=points[i][0]*points[i][0]+points[i][1]*points[i][1];
            temp.put(i,sqrt);
        }
        LinkedHashMap<Integer,Integer> sortedMap=new LinkedHashMap<>();
        temp.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x->sortedMap.put(x.getKey(),x.getValue()));
        int count=0;
        for (Integer k:sortedMap.keySet()){
            if(count>=K){
                break;
            }
            result[count++]=points[k];
        }

        return result;
    }
}
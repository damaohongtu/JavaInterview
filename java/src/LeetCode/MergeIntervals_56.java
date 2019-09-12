package LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;

/**
 * @Classname MergeIntervals_56
 * @Description 将数组重叠的部分合并,返回去除交叉后的二维数组
 * 思路:使用LinkedHasMap
 * @Date 19-5-21 上午8:55
 * @Created by mao<tianmao818@qq.com>
 */
public class MergeIntervals_56 {
    public int[][] merge(int[][] intervals) {
        int len=intervals.length;
        if(len==0){
            return new int[0][2];
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        LinkedHashMap<Integer,Integer> map=new LinkedHashMap<>();
        map.put(intervals[0][0],intervals[0][1]);
        int key=intervals[0][0];

        for(int i=1;i<len;i++){
            if(intervals[i][0]>map.get(key)){
                map.put(intervals[i][0],intervals[i][1]);
                key=intervals[i][0];
            }else {
                if(intervals[i][1]>map.get(key)){
                    map.put(key,intervals[i][1]);
                }
            }
        }
        int l=map.keySet().size();
        int[][] ans=new int[l][2];
        int j=0;
        for(Integer i:map.keySet()){
            ans[j][0]=i;
            ans[j][1]=map.get(i);
            j++;
        }
        return ans;
    }
}

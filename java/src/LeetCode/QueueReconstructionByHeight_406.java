package LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Classname QueueReconstructionByHeight_406
 * @Description 重新排序这个二元组,[h,k]满足排序后的结果
 * (1)排序方式选择
 * (2)数据结构的选择
 * @Date 19-5-15 下午9:20
 * @Created by mao<tianmao818@qq.com>
 */
public class QueueReconstructionByHeight_406 {
    public static int[][] reconstructQueue(int[][] people) {

        int m=people.length;
        if(m==0){
            return new int[m][2];
        }
        int n=people[0].length;

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }
                return o2[0]-o1[0];
            }
        });

        List<int[]> result=new LinkedList<>();
        for(int i=0;i<people.length;i++){
            result.add(people[i][1],people[i]);
        }
        return result.toArray(new int[m][n]);
    }

    public static void main(String[] args){
        int[][] test={{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        int[][] result=reconstructQueue(test);
        for(int i=0;i<result.length;i++){
            System.out.println("{"+result[i][0]+","+result[i][1]+"}");
        }

    }
}

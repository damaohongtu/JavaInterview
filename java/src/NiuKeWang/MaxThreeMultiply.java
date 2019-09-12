package NiuKeWang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Classname MaxThreeMultiply
 * @Description TODO
 * @Date 19-3-16 下午3:14
 * @Created by mao<tianmao818@qq.com>
 */
public class MaxThreeMultiply {
    //大顶堆
    private PriorityQueue<Integer> queue1=new PriorityQueue<>();
    //小顶堆
    private PriorityQueue<Integer> queue2=new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });
    public long maxTreeMul(int[] nums){
        for (int i=0;i<nums.length;i++){
            queue1.add(nums[i]);
            queue2.add(nums[i]);
        }
        int[] min=new int[3];
        int[] max=new int[3];
        for(int i=0;i<3;i++){
            min[i]=queue1.peek();
            queue1.poll();
            max[i]=queue2.peek();
            queue2.poll();
        }
        long a=min[0]*min[1]*max[0];
        long b=max[0]*max[1]*max[2];
        return a>b?a:b;
    }
    public static void main(String[] args) throws IOException {
        MaxThreeMultiply yun=new MaxThreeMultiply();
        int[] test={3472, -7098, -9281, 7789, 7955, 6101, 5051, 7778, 3090, 7423, -7151, 5652, 1595, -8094, 677, -8324, 8347, -2482, 9313, -9338, -3157, 8559, 6945, 3618, 3087, 121 ,-8468 ,3225 ,1356 ,6939 ,2799 ,-7231, -6309, -5453, 633, -8689, -4776, 2714, -2743, -1409, 5918, -3333 ,1803 ,8330 ,-2206 ,-6117 ,-4486 ,-7903 ,-4375 ,-3739 ,2897 ,8056, -5864, -522 ,7451, -4541, -2813, 5790 ,-532 ,-6517 ,925};
        System.out.println(yun.maxTreeMul(test));
        System.out.println(+1);
    }
}
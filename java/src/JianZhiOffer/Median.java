package JianZhiOffer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Classname Median
 * @Description TODO
 * @Date 19-3-12 上午9:41
 * @Created by mao<tianmao818@qq.com>
 */
public class Median {
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){ //大顶堆，容量11
        public int compare(Integer i1,Integer i2){
            return i2-i1;
        }
    });
    public void Insert(Integer num) {
        if(((minHeap.size()+maxHeap.size())&1)==0){//偶数时,下个数字加入小顶堆
            if(!maxHeap.isEmpty() && maxHeap.peek()>num){
                maxHeap.offer(num);
                num=maxHeap.poll();
            }
            minHeap.offer(num);
        }else{//奇数时，下一个数字放入大顶堆
            if(!minHeap.isEmpty() && minHeap.peek()<num){
                minHeap.offer(num);
                num=minHeap.poll();
            }
            maxHeap.offer(num);
        }
    }

    public Double GetMedian() {
        if((minHeap.size()+maxHeap.size())==0)
            throw new RuntimeException();
        double median;
        if((minHeap.size()+maxHeap.size()&1)==0){
            median=(maxHeap.peek()+minHeap.peek())/2.0;
        }else{
            median=minHeap.peek();
        }
        return median;
    }
}
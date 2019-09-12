package JianZhiOffer;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @Classname MaxInWindows
 * @Description 滑动窗口最大值
 * @Date 19-3-5 下午3:19
 * @Created by mao<tianmao818@qq.com>
 */
public class MaxInWindows {
    public List<Integer> getMaxINWindows(int[] nums, int size){

        List<Integer> maxInWindows=new ArrayList<>();
        //存放下标
        List<Integer> index=new ArrayList<>();
        for(int i=0;i<size;i++){
            while(!index.isEmpty() && nums[i]>=nums[index.get(index.size()-1)]){
                index.remove(index.size()-1);
            }
            //这里并不一定只添加了一个元素
            index.add(i);
        }
        for(int i=size;i<nums.length;i++){
            maxInWindows.add(nums[index.get(0)]);
            //新加入的比尾部的要大
            while(!index.isEmpty() && nums[i]>=nums[index.get(index.size()-1)]){
                index.remove(index.size()-1);
            }
            //超出滑动窗口的大小,也保证了index不会超过size
            while (!index.isEmpty() && index.get(0)<=i-size){
                index.remove(0);
            }
            index.add(i);
        }
        maxInWindows.add(nums[index.get(0)]);
        return maxInWindows;
    }

    public List<Integer> getMaxInWindow2(int[] nums,int size){
        List<Integer> maxInWindows=new ArrayList<>();
        PriorityQueue<Integer> index=new PriorityQueue<>(size,(i,j)->(nums[j]-nums[i]));

        for(int i=0;i<size;i++){
            index.add(i);
        }

        maxInWindows.add(nums[index.peek()]);
        for(int j=size;j<nums.length;j++){
            index.add(j);
            //z
            while(j-index.peek()>=size){
                index.poll();
            }
            maxInWindows.add(nums[index.peek()]);
        }

        return maxInWindows;
    }


    public static void main(String[] args){
        MaxInWindows maxInWindows=new MaxInWindows();
        int[] test={2,3,4,2,6,2,5,1,6};
        System.out.println(maxInWindows.getMaxINWindows(test,3));
        System.out.println(maxInWindows.getMaxInWindow2(test,3));
    }
}

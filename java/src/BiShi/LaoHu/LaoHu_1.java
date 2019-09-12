package BiShi.LaoHu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Author MaoTian
 * @Classname LaoHu_1
 * @Description TODO
 * @Date 下午8:20 2019/9/2
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class LaoHu_1 {
    //冒泡排序--->两两进行交换,将最小或者最大的数值冒泡到顶端(注意是依次两两交换)
    //arrshi输入数组，len是数组的长度
    int bubble_sort(long[] arr,int len){
        //交换的次数
        int count=0;
        for(int i=0;i<len;i++){
            int flag=0;
            for(int j=1;j<len-i;j++){
                if(arr[j]<arr[j-1]){
                    long tmp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=tmp;
                    count++;
                }
            }
        }
        return count;
    }

}

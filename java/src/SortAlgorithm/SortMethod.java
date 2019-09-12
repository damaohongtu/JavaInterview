package SortAlgorithm;/**
 * @Classname SortMethod
 * @Description 各种排序算法总结
 * @Date 19-7-11 下午8:15
 * @Created by mao<tianmao818@qq.com>
 */
class Methods{

    //冒泡排序--->两两进行交换,将最小或者最大的数值冒泡到顶端(注意是依次两两交换)
    void bubble_sort(int[] arr,int len){
        for(int i=0;i<len;i++){
            int flag=0;
            for(int j=1;j<len-i;j++){
                if(arr[j]<arr[j-1]){
                    int tmp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=tmp;
                }
            }
            //优化
            if(flag==1){
                return;
            }
        }
    }
    //插入排序--->从没有排好序的中取值,插入到已经排好顺序的中去(对于已经排好顺序的进行插入可以使用二分查找)
    //(1)直接插入
    public void insert_sort(int[] arr,int len){
        for(int i=1;i<len;i++){
            if(arr[i]<arr[i-1]){
                int temp=arr[i];
                int j;
                //向有序的数组中插入
                for(j=i-1;j>=0 && arr[j]>temp;j--){
                    arr[j+1]=arr[j];
                }
                arr[j+1]=temp;
            }
        }
    }
    //(2)使用二分查找确定插入位置
    public void insert_binary_sort(int arr[], int len){
        //改进的插入排序，往前插入比较时，进行二分查找
        for (int i = 1; i < len; i++){
            //存在逆序
            if (arr[i] < arr[i - 1]){
                int temp = arr[i];
                int low = 0, high = i - 1, mid;

                while (low <= high){
                    mid = (low + high) / 2;
                    if (temp < arr[mid]){
                        high = mid - 1;
                    }
                    else{
                        low = mid + 1;
                    }
                }
                for (int j = i; j >low; j--){
                    arr[j] = arr[j - 1];
                }
                arr[low] = temp;
            }
        }
    }

    //希尔排序--->选择不同的gap,进行插入排序,一直到最终的gap为1
    public void shell_sort(int[] arr,int len){
        //每次选择一个gap，对相隔gap的数进行插入排序
        for (int gap = len / 2; gap > 0; gap /= 2){
            for (int i = 0; i < len; i = i + gap){
                int temp = arr[i];
                int j;
                //和插入排序相比区别在于gap
                for (j = i; j >= gap && temp < arr[j-gap]; j -= gap){
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }

    //选择排序--->每次选择最小的向前追加
    void select_sort(int arr[], int len){
        //每次从后边选择一个最小值
        for (int i = 0; i < len-1; i++){     //只需选择n-1次
            int min = i;
            for (int j = i+1; j < len; j++){
                if (arr[min]>arr[j]){
                    min = j;
                }
            }
            if (min != i){
                int tmp=arr[i];
                arr[i]=arr[min];
                arr[min]=tmp;
            }
        }
    }

    //快速排序--->选择一个基准,左右分+递归
    int partition(int arr[], int left, int right){
        //对序列进行划分，以第一个为基准
        int pivot = arr[left];
        //下标为left
        int pivotpos = left;
        //遍历
        for (int i = left+1; i <= right; i++){
            if (arr[i] < pivot){
                //移动下标
                pivotpos++;
                //交换
                if (pivotpos != i){
                    int tmp=arr[i];
                    arr[i]=arr[pivotpos];
                    arr[pivotpos]=tmp;
                }
            }
        }
        arr[left] = arr[pivotpos];
        arr[pivotpos] = pivot;
        //返回下标
        return pivotpos;
    }
    void quick_sort(int arr[],int left,int right){
        if (left < right){
            //获取位置
            int pivotpos = partition(arr, left, right);
            //左边
            quick_sort(arr, left, pivotpos - 1);
            //右边
            quick_sort(arr, pivotpos + 1, right);
        }
    }
    void quick_sort(int arr[], int len){
        quick_sort(arr, 0, len - 1);
    }


    //归并排序--->将n个元素平均划分为各含n/2个元素的子序列；
    // 递归的解决俩个规模为n/2的子问题；
    // 合并俩个已排序的子序列。

    //堆排序--->将待排序的序列构造成一个最大堆，此时序列的最大值为根节点;
    // 依次将根节点与待排序序列的最后一个元素交换;
    // 再维护从根节点到该元素的前一个节点为最大堆，如此往复，最终得到一个递增序列

}
public class SortMethod {
    public static void main(String[] args){
        Methods methods=new Methods();
        int[] test={2,1,7,3,5,9,9,4};
//        methods.bubble_sort(test,8);
//        methods.shell_sort(test,8);
//        methods.select_sort(test,8);
        methods.quick_sort(test,8);

        for(int i:test){
            System.out.println(i);
        }
    }
}

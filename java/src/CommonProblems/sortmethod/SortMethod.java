package CommonProblems.sortmethod;/**
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
    public void mergeSort(int[] nums,int left,int right){
        if(left<right){
            int mid=(left+right)>>1;
            mergeSort(nums,left,mid);
            mergeSort(nums,mid+1,right);
            merge(nums,left,right,mid);
        }
    }
    public void merge(int[] nums,int left,int right,int mid){

        int leftPos=left;
        int pos=left;
        int rightPos=mid+1;
        int len=right-left+1;
        int[] tmp=new int[nums.length];

        while(leftPos<=mid&&rightPos<=right){
            if(nums[leftPos]>nums[rightPos]){
                tmp[pos++]=nums[rightPos++];
            }else{
                tmp[pos++]=nums[leftPos++];
            }
        }

        while(leftPos<=mid){
            tmp[pos++]=nums[leftPos++];
        }

        while(rightPos<=right){
            tmp[pos++]=nums[rightPos++];
        }
        int m=left;
        int n=left;
        for(int i=0;i<len;i++){
            nums[m++]=tmp[n++];
        }
    }



    //堆排序--->将待排序的序列构造成一个最大堆，此时序列的最大值为根节点;
    // 依次将根节点与待排序序列的最后一个元素交换;
    // 再维护从根节点到该元素的前一个节点为最大堆，如此往复，最终得到一个递增序列

    public static void headsort(int []arr){

        //1.构建大顶堆（头部就是0）
        for(int i=arr.length/2-1;i>=0;i--){
            //从第一个非叶子结点从下至上，从右至左调整结构（不包含length）
            adjustHeap(arr,i,arr.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素（取值length-1次）
        for(int j=arr.length-1;j>0;j--){
            swap(arr,0,j);//将堆顶元素与末尾元素进行交换
            adjustHeap(arr,0,j);//重新对堆进行调整（不包含j）
        }

    }

    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     * @param arr
     * @param i
     * @param length
     */
    public static void adjustHeap(int []arr,int i,int length){
        int temp = arr[i];//先取出当前元素i
        for(int k=i*2+1;k<length;k=k*2+1){//从i结点的左子结点开始，也就是2i+1处开始
            if(k+1<length && arr[k]<arr[k+1]){//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if(arr[k] >temp){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        arr[i] = temp;//将temp值放到最终的位置
    }

    public static void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }




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

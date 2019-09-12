package JavaBasic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySearchTest {


    public int binarySearch(int[] nums,int target){
        int start=0;
        int end=nums.length-1;
        while (start<=end){
            int mid=(start+end)/2;
            if (nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> test=new ArrayList<>();
        test.add(2);
        test.add(6);
        test.add(8);
        test.add(8);
        int a=Arrays.binarySearch(test.toArray(),3);
        int b=Collections.binarySearch(test,1);
        System.out.println(a);
        System.out.println(b);
        int[] nums={2,6,8,8};
        BinarySearchTest binarySearchTest=new BinarySearchTest();
        System.out.println(binarySearchTest.binarySearch(nums,3));
    }
}

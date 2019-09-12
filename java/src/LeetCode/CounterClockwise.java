package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class CounterClockwise {
    public void printMatrixClockWise(int[][]nums){
        int start=0;
        int w=nums[0].length;
        int h=nums.length;
        while (w>2*start && h>2*start){
            printMatrixInCircle(nums,start);
            start++;
        }
    }
    public void printMatrixInCircle(int[][] nums,int start){
        int endX=nums[0].length-start-1;
        int endY=nums.length-start-1;
        for(int i=start;i<=endX;i++){
            System.out.println(nums[start][i]);
        }
        if(start<endY){
            for(int i=start+1;i<=endY;i++){
                System.out.println(nums[i][endX]);
            }
        }
        if(start<endX && start<endY){
            for(int i=endX-1;i>=start;i--){
                System.out.println(nums[endY][i]);
            }
        }
        if(start<endX && start<endY-1){
            for(int i=endY-1;i>start;i--){
                System.out.println(nums[i][start]);
            }

        }
    }
    public static void main(String[] args){
        CounterClockwise counterClockwise=new CounterClockwise();
        int[][]nums={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        counterClockwise.printMatrixClockWise(nums);
    }
}

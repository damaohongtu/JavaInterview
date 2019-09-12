package LeetCode;

import java.util.Arrays;

/**
 * @Classname LargestPerimeterTriangle
 * @Description TODO
 * @Date 19-2-28 下午4:19
 * @Created by mao<tianmao818@qq.com>
 */
public class LargestPerimeterTriangle {
    public int largestPerimeter(int[] A) {
//        int result=-1;
//        Arrays.sort(A);
//        int l=A.length;
//        for(int i=0;i<l-2;i++){
//            for(int j=i+1;j<l-1;j++){
//                for(int k=j+1;k<l;k++){
//                    int sum=A[i]+A[j]+A[k];
//                    if(check(A[i],A[j],A[k]) && result<sum){
//                        result=sum;
//                    }
//                }
//            }
//        }
//        return result;
        if(A.length<3)  return 0;
        Arrays.sort(A);
        for(int i=A.length-1;i>=2;i--){
            if(A[i-2]+A[i-1]>A[i])  return A[i-2]+A[i-1]+A[i];
        }
        return 0;
    }
//    public boolean check(int a,int b,int c){
//        if(a+b>c && a+c>b && b+c>a){
//            return true;
//        }
//        return false;
//    }
}
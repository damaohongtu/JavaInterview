package BiShi;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @Classname PinDuoDuo_1
 * @Description TODO
 * @Date 19-7-28 下午1:48
 * @Created by mao<tianmao818@qq.com>
 */
public class PinDuoDuo_1 {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(new File("/home/mao/workspace/java/src/BiShi/pinduoduo1"));
        while(sc.hasNextLine()){
            String s1=sc.nextLine();
            String s2=sc.nextLine();

            String[] nums1=s1.split(" ");

            if(nums1.length==1){
                System.out.println(nums1[0]);
                continue;
            }
            String[] nums2=s2.split(" ");


            ArrayList<Integer> arr1=new ArrayList<>();
            ArrayList<Integer> arr2=new ArrayList<>();

            for(String s:nums1){
                arr1.add(Integer.parseInt(s));
            }
            for(String s:nums2){
                arr2.add(Integer.parseInt(s));
            }

            int index=0;
            for(int i=1;i<arr1.size();i++){

                if(arr1.get(i)<=arr1.get(i-1)){
                    index=i;
                    break;
                }
            }

            if((arr1.size()>1)&&(arr1.get(0)>arr1.get(1))){
                index=0;
            }

            Collections.sort(arr2);

            int flag=0;

            for(int j=arr2.size()-1;j>=0;j--){

                if(index==(arr1.size()-1)){
                    if(arr2.get(j)>arr1.get(index-1)){
                        arr1.set(index,arr2.get(j));
                        flag=1;
                        break;
                    }

                }else if(index==0){
                    if(arr2.get(j)<arr1.get(index+1)){
                        arr1.set(index,arr2.get(j));
                        flag=1;
                        break;
                    }
                }else{
                    if((arr2.get(j)>arr1.get(index-1))&&((arr2.get(j)<arr1.get(index+1)))){
                        arr1.set(index,arr2.get(j));
                        flag=1;
                        break;
                    }
                }
            }
            String res="";
            if(flag==1){
                for(Integer i:arr1){
                    res=res+i+" ";
                }
                System.out.println(res);
            }else{
                System.out.println("NO");
            }

        }
    }

}

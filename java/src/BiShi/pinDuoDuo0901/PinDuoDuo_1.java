package BiShi.pinDuoDuo0901;

import java.io.File;
import java.util.*;

public class PinDuoDuo_1 {
    public static void main(String[] args)throws Exception {
        Scanner sc=new Scanner(new File("/home/mao/workspace/java/src/BiShi/pinDuoDuo0901/test1"));
        //Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String s=sc.nextLine();
            String[] ss=s.split(";");
            String[] num=ss[0].split(",");
            int N=Integer.parseInt(ss[1]);
            //偶数
            ArrayList<Integer>nums1=new ArrayList<>();
            //奇数
            ArrayList<Integer>nums2=new ArrayList<>();
            for(int i=0;i<num.length;i++){
                int tmp=Integer.parseInt(num[i]);
                if(tmp%2==0){
                    nums1.add(tmp);
                }else{
                    nums2.add(tmp);
                }
            }
            Collections.sort(nums1, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            });
            Collections.sort(nums2, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            });
            int len1=nums1.size();
            int len2=nums2.size();
            if(len1>=N){
                for(int i=0;i<N-1;i++){
                    System.out.print(nums1.get(i)+",");
                }
                System.out.println(nums1.get(N-1));
            }else{
                int len=N-len1;
                for (int i=0;i<len1;i++){
                    System.out.print(nums1.get(i)+",");
                }
                for(int j=0;j<len-1;j++){
                    System.out.print(nums2.get(j)+",");
                }
                System.out.println(nums2.get(len-1));
            }



        }
    }
}

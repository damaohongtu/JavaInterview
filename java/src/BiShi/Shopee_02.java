package BiShi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @Classname Shopee_02
 * @Description TODO
 * @Date 19-7-27 下午6:53
 * @Created by mao<tianmao818@qq.com>
 */

public class Shopee_02 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int count=sc.nextInt();
            int target=sc.nextInt();
            ArrayList<Integer> nums=new ArrayList<>();
            for(int i=0;i<count;i++){
                nums.add(sc.nextInt());
            }
            Collections.sort(nums);
            count=0;

            for(int i=0;i<count;i++){
                int tmp=0;
                for(int j=i;j<count;j++){
                    tmp=tmp+nums.get(j);
                    if(tmp==target){
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

}

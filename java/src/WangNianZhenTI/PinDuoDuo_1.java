package WangNianZhenTI;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @Classname PinDuoDuo_1
 * @Description TODO
 * @Date 19-7-28 下午1:49
 * @Created by mao<tianmao818@qq.com>
 */

public class PinDuoDuo_1 {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(new File("/home/mao/workspace/java/src/WangNianZhenTI/test"));
        while (sc.hasNext()){
            int count=sc.nextInt();
            ArrayList<Integer> nums=new ArrayList<>();
            for(int i=0;i<count;i++){
                nums.add(sc.nextInt());
            }
            Collections.sort(nums);

            int mid=count/2;
            ArrayList<Integer> ans=new ArrayList<>();
            for(int i=0;i<mid;i++){
                ans.add(nums.get(i)+nums.get(count-1-i));
            }
            Collections.sort(ans);
            System.out.print(ans.get(mid-1)-ans.get(0));
        }
    }
}

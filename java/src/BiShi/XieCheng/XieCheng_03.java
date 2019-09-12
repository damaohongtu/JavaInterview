package BiShi.XieCheng;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @Author MaoTian
 * @Classname XieCheng_01
 * @Description TODO
 * @Date 下午6:51 2019/9/4
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class XieCheng_03 {

    static int schedule(int m,int[] array) {

        int sum=0;
        for(int i=0;i<array.length;i++){
            sum+=array[i];
        }
        int max=array[0];
        for(int i=0;i<array.length;i++){
            if(max<array[i]){
                max=array[i];
            }
        }
        int start=sum/m>max?sum/m:max;

        while(true){
            int count=0;
            int tmp=0;

            for(int i=0;i<array.length;i++){
                tmp=tmp+array[i];
                if(tmp>start){
                    count++;
                    tmp=0;
                    i--;
                }
            }
            if(count<=m){
                break;
            }
            start=start+1;
        }
        return start;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in=new Scanner(new File("/home/mao/workspace/java/src/BiShi/XieCheng/test3"));
//        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int size  = in.nextInt();
        int[] array = new int[size];
        for(int i = 0; i < size; i++) {
            array[i] = in.nextInt();
        }
        int res = schedule(m,array);
        System.out.println(String.valueOf(res));
    }
}

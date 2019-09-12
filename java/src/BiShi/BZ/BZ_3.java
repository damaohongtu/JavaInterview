package BiShi.BZ;

import java.io.File;
import java.util.Scanner;

/**
 * @Author MaoTian
 * @Classname BZ_3
 * @Description TODO
 * @Date 下午6:24 2019/9/10
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class BZ_3 {
    public static void main(String[] args)throws Exception {
        Scanner sc =new Scanner(new File("/home/mao/workspace/java/src/BiShi/BZ/test3"));
        //Scanner sc =new Scanner(System.in);
        //
        //  # : a:3#b:8#c:9
        while(sc.hasNext()){
            String s=sc.nextLine();
            String[] columns=s.split(" ");
            String column_1=columns[0];
            String column_2=columns[1];
            String column_3=columns[2];
            String[] pair=column_3.split(column_1);
            int count=pair.length;
            System.out.println(count);
            for (String ss:pair){
                String[] key_value=ss.split(column_2);
                System.out.println(key_value[0]+" "+key_value[1]);
            }
        }
    }
}

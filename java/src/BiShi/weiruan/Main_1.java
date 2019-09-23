package BiShi.weiruan;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @Author MaoTian
 * @Classname Main_1
 * @Description TODO
 * @Date 下午7:18 2019/9/22
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class Main_1 {
    public static void main(String[] args)throws Exception {
        Scanner sc =new Scanner(new File(""));
        //Scanner sc =new Scanner(System.in);
        while(sc.hasNext()){
            int N=Integer.parseInt(sc.next());
            String[] arr=new String[N];
            for (int i = 0; i <N ; i++) {
                arr[i]=sc.next();
            }
            HashSet<String> set=new HashSet<>();

        }
    }
}

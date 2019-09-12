package BiShi;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @Classname Test_02_HuaWei_03
 * @Description TODO
 * @Date 19-4-10 下午6:52
 * @Created by mao<tianmao818@qq.com>
 */
public class Test_02_HuaWei_03 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("/home/mao/workspace/java/src/BiShi/test4"));

        while(sc.hasNext()){
            System.out.print(sc.next());
        }
    }
}
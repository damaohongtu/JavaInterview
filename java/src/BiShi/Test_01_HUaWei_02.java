package BiShi;

import java.util.Scanner;

/**
 * @Classname Test_01_HUaWei_02
 * @Description TODO
 * @Date 19-4-3 下午5:04
 * @Created by mao<tianmao818@qq.com>
 */
public class Test_01_HUaWei_02 {
    public static void main(String[] args){

        Scanner sc2 =new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        System.out.println(sc2.nextInt());
        System.out.println("----------------------");
        while (sc1.hasNext()){
            String s = sc1.nextLine();
            String[] num=s.split(" ");
            for(int i=0;i<num.length;i++){
                System.out.println(Integer.parseInt(num[i]));
            }
        }
    }
}
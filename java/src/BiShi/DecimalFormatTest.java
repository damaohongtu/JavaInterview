package BiShi;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class DecimalFormatTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double data;
        data = sc.nextDouble();

        // 第一种
        DecimalFormat df = new DecimalFormat("#0.00");
        df.setRoundingMode(RoundingMode.DOWN);
        System.out.println(df.format(data));

        // 第二种,模仿c语言的输出方式
        System.out.printf("%.2f\n", data);

        // 第三种
        System.out.println(String.format("%.2f", data));

    }

}
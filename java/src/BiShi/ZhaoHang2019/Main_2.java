package BiShi.ZhaoHang2019;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author MaoTian
 * @Classname Main_2
 * @Description 括号全排列，全排列考虑使用dfs算法！！！
 * @Date 下午12:07 2019/9/14
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class Main_2 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        List<String> list = new ArrayList<>();

        DFS(0, 0, n, "", list);


        for (int i = 0; i < list.size() - 1; i++) {
            System.out.print(list.get(i) + ",");
        }

        System.out.println(list.get(list.size() - 1));

    }


    public static void DFS(int num1, int num2, int n, String str, List<String> list) {

        if (num1 == n && num1 + num2 == 2 * n){
            list.add(str);
        }

        if (num1 < n && num1 >= num2 && num1 + num2 < 2 * n){
            DFS(num1 + 1, num2, n, str + '(', list);
        }

        if (num2 < n && num1 + num2 < 2 * n){
            DFS(num1, num2 + 1, n, str + ')', list);
        }
    }
}
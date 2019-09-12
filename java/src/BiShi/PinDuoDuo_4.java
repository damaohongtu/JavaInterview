package BiShi;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @Classname PinDuoDuo_4
 * @Description TODO
 * @Date 19-7-28 下午2:56
 * @Created by mao<tianmao818@qq.com>
 */
public class PinDuoDuo_4 {

    static class Box {
        int len;
        int weight;
    }

    public static void main(String[] args)throws  Exception{
//        Scanner in = new Scanner(System.in);
        Scanner in = new Scanner(new File("/home/mao/workspace/java/src/BiShi/pinduoduo4"));
        while(in.hasNext()) {
            int n = in.nextInt();
            Box[] b = new Box[n+1];
            b[0] = new Box();
            for(int i = 1; i < n+1; ++i) {
                b[i] = new Box();
                b[i].len = in.nextInt();
            }
            for(int i = 1; i < n+1; ++i) {
                b[i].weight = in.nextInt();
            }
            Arrays.sort(b, (b1, b2) -> {return b1.len == b2.len ? b1.weight-b2.weight : b1.len - b2.len;});
            int res = 0;
            int[][] dp = new int[n+1][n+1];
            for(int i = 0; i < n+1; ++i) {
                for(int j = 0; j < n+1; ++j) {
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
            dp[0][0] = 0;
            for(int i = 1; i < n+1; ++i) {
                for(int k = 0; k < i; ++k) {
                    if(b[k].len < b[i].len) {
                        for(int j = 0; j <= k; ++j) {
                            if(dp[k][j] != Integer.MAX_VALUE && dp[k][j] <= b[i].weight*7) {
                                dp[i][j+1] = Math.min(dp[i][j+1], dp[k][j]+b[i].weight);
                                res = Math.max(res, j+1);
                            }
                        }
                    }
                }
            }
            System.out.println(res);
        }
    }
}

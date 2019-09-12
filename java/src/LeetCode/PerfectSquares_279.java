package LeetCode;/**
 * @Classname PerfectSquares_279
 * @Description 表示成为平方的和
 * 解决方案:任何一个正整数可以被表示为最多四个整数的平方和
 * @Date 19-5-21 下午1:51
 * @Created by mao<tianmao818@qq.com>
 */
public class PerfectSquares_279 {


    public int numSquares(int n) {
        if (n == 0) return 0;
        if (isSquare(n)) return 1;
        if (isSumOfFourIntegers(n)) return 4;
        if (isSumOfSquares(n)) return 2;
        return 3;
    }

    private boolean isSquare(int n) {
        int squareRoot = squareRoot(n);
        return squareRoot * squareRoot == n;
    }

    private int squareRoot(int n) {
        return (int) Math.sqrt(n);
    }

    // Values of the form 4^n(8k+7) are the sum of 4 integers.
    private boolean isSumOfFourIntegers(int n) {
        while (n % 4 == 0) n /= 4;
        return n % 8 == 7;
    }

    // O(sqrt(n))
    private boolean isSumOfSquares(int n) {
        for (int i = 1; i <= squareRoot(n); i++) {
            if (isSquare(n - (i * i))) return true;
        }

        return false;
    }

}

package CommonProblems.Dynamic;

/**
 * @Author MaoTian
 * @Classname BeiBao
 * @Description https://blog.csdn.net/u013885699/article/details/80248536
 * @Date 下午5:44 2019/8/15
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class BeiBao {
    static int V = 5;//背包容积为5
    static int n = 4;//物品数量为4
    static int[] v = {0, 4, 2, 3, 4};//每个物品的体积
    static int[] w = {0, 2, 4, 4, 5};//每个物品的价值

    public static void main(String[] args) {
        int[] f = new int[V + 1];
        for (int i = 1; i <= n; i++)
            for (int j = V; j >= v[i]; j--)//终止条件可以写在这里
                f[j] = Math.max(f[j], f[j - v[i]] + w[i]);
        System.out.println(f[V]);
    }
}

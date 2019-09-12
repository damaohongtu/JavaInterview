package CommonProblems.UnionFind;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author MaoTian
 * @Classname LeetCode547
 * @Description 思路：使用一个数组来记录所有节点自己的父亲，对于每一个节点都找到自己的终极父亲，最后使用set
 * @Date 下午7:34 2019/8/26
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class LeetCode547 {

    private int unionFind(int[][] M) {
        int n = M.length;
        int[] parent = new int[n];
        //记录的是父节点的度
        int[] rate = new int[n];

        //parent记录自己的父亲，初始为自己
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        //通过每一个连接合并
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                //有连接就合并
                if (M[i][j] == 1) {
                    union(parent, rate, i, j);
                }
            }
        }

        //求父节点的数目
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(find(parent, i));
        }
        return set.size();
    }

    //合并相互连接的节点
    private void union(int[] parent, int[] rate, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);

        if (rootX != rootY) {
            //使用最小的度作为父节点
            if (rate[rootX] > rate[rootY]) {
                parent[rootY] = rootX;
                rate[rootX]++;
            } else {
                parent[rootX] = rootY;
                rate[rootY]++;
            }
        }
    }

    //递归操作，寻找父节点
    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
            return parent[x];
        }
        return x;
    }

}

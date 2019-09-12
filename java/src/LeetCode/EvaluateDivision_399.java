package LeetCode;

import java.util.*;

/**
 * @Classname EvaluateDivision_399
 * @Description 给出两个数字相除的关系,除法化简,依靠中间变量
 * Example:
 * Given a / b = 2.0, b / c = 3.0.
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
 * return [6.0, 0.5, -1.0, 1.0, -1.0 ].
 *
 * equations = [ ["a", "b"], ["b", "c"] ],
 * values = [2.0, 3.0],
 * queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 *
 * 思路:并查集,使用hashMap,利用中间变量,使用联合查找的方式
 * 思路2:使用图论,求多对多点之间的距离,使用floyd算法
 *


 * @Date 19-5-20 上午10:24
 * @Created by mao<tianmao818@qq.com>
 */
public class EvaluateDivision_399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        UF uf = new UF();
        for(int i = 0; i < values.length; i++) {
            uf.union(equations.get(i).get(0), equations.get(i).get(1), values[i]);
        }
        double[] res = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++) {
            res[i] = uf.get(queries.get(i).get(0), queries.get(i).get(1));
        }
        return res;
    }
}

class UF {
    //存储两个变量之间的关系
    HashMap<String, String> p;
    //存储变量之间的数值
    HashMap<String, Double> r;

    //构造函数
    UF() {
        p = new HashMap<>();
        r = new HashMap<>();
    }
    //查找方法,压缩
    String find(String a) {

        //不包含
        if(!p.containsKey(a)) {
            p.put(a,a);
            r.put(a,1.0);
            return a;
        }

        double value = r.get(a);
        String parent = a;

        //
        while(p.get(parent) != parent) {
            parent = p.get(parent);
            value *= r.get(parent);
        }
        //Compress path and update relation value
        p.put(a,parent);
        r.put(a,value);

        //返回各自依赖的中间变量
        return parent;
    }

    void union(String a, String b, double v) {
        String p1 = find(a);
        String p2 = find(b);

        //依赖的同一个中间变量
        if(p1 == p2) return;

        // a/b = 2 -> a = 2b
        // b/c = 3 -> b = 3c -> a/2 = 3c -> a = 6c
        double r1 = r.get(a);
        double r2 = r.get(b);
        p.put(p2,p1);
        // a/b = 2
        // a/c = 6
        r.put(p2, r1/r2*v);
    }
    double get(String a, String b) {
        if(!p.containsKey(a) || !p.containsKey(b)) {
            return -1.0;
        }
        // System.out.println(r.get(b) + " " + r.get(a));
        String p1 = find(a);
        String p2 = find(b);
        //Not connected
        if(p1 != p2) return -1.0;

        // p1 = a/a = 1
        // p2 = a/c = 6
        // p2/p1 = a/c = 6

        // p1 = a/b = 2
        // p2 = a/c = 6
        // p2/p1 = b/c = 6/2
        return r.get(b)/r.get(a);
    }



    //思路2,使用图论的方法
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {


        //建立一张有向图
        Map<String, Map<String, Double>> graph = new HashMap<>();

        double[] res = new double[queries.length];
        int idx = 0;

        for (int i = 0; i < equations.length; i++) {
            String u = equations[i][0];
            String v = equations[i][1];

            //正
            if (!graph.containsKey(u)) {
                graph.put(u, new HashMap<>());
            }
            graph.get(u).put(v, values[i]);

            //反
            if (!graph.containsKey(v)) {
                graph.put(v, new HashMap<>());
            }
            graph.get(v).put(u, 1.0 / values[i]);
        }

        for (int i = 0; i < queries.length; i++) {
            String u = queries[i][0];
            String v = queries[i][1];
            Set<String> visited = new HashSet<>();
            double val = helper(u, v, graph, 1, visited);
            res[idx] = val;
            idx++;
        }

        return res;
    }

    private double helper(String u, String v, Map<String, Map<String, Double>> graph, double curval, Set<String> visited) {


        //首先执行这里,如[x,x]的情况
        if (u.equals(v)) {
            return curval;
        }

        //图中并不包含任何一个键
        if (!graph.containsKey(u) || !graph.containsKey(v)) {
            return -1.0;
        }

        //已经走过了
        if (visited.contains(u)) {
            return -1.0;
        }

        visited.add(u);

        //所有的下一个节点
        Map<String, Double> neighbors = graph.get(u);
        for (String n : neighbors.keySet()) {
            double res = helper(n, v, graph, curval * neighbors.get(n), visited);
            if (res != -1.0) {
                return res;
            }
        }
        return -1.0;
    }



}


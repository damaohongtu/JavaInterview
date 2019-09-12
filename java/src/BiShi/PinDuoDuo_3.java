package BiShi;

import java.io.File;
import java.util.*;

/**
 * @Classname PinDuoDuo_3
 * @Description 任务调度问题，每次处理度为0的，而且耗时最小的
 * @Date 19-7-28 下午1:48
 * @Created by mao<tianmao818@qq.com>
 */
public class PinDuoDuo_3 {

    static class Task {
        int seq;
        int weight;
        public Task(int n, int w) {
            seq = n;
            weight = w;
        }
    }
    public static void main(String[] args)throws Exception {
//        Scanner in = new Scanner(System.in);
        Scanner in = new Scanner(new File("/home/mao/workspace/java/src/BiShi/pinduoduo3"));
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            Task[] t = new Task[n+1];
            for(int i = 1; i < n+1; ++i) {
                t[i] = new Task(i, in.nextInt());
            }

//            建图
            Map<Integer, List<Integer>> graph = new HashMap<>();
            int[] indegree = new int[n+1];
            for(int i = 0; i < m; ++i) {
                int u = in.nextInt();
                int v = in.nextInt();
                if(graph.containsKey(u)) {
                    graph.get(u).add(v);
                } else {
                    List<Integer> edges = new ArrayList<>();
                    edges.add(v);
                    graph.put(u, edges);
                }
                indegree[v]++;
            }
            //按照权重排序
            PriorityQueue<Task> queue = new PriorityQueue<>(new Comparator<Task>() {
                public int compare(Task o1, Task o2) {
                    return o1.weight-o2.weight;
                }
            });

            //加入度为0的节点，肯定有度为0的节点，否则就是环
            for(int i = 1; i < n+1; ++i) {
                if(indegree[i] == 0) queue.offer(t[i]);
            }

            List<Integer> res = new ArrayList<>();

            while(!queue.isEmpty()) {
                //出堆
                Task complete = queue.poll();
                //保存结果
                res.add(complete.seq);
                if(graph.containsKey(complete.seq)) {
                    //修改度数
                    for(int i : graph.get(complete.seq)){
                        //度数为0，加入堆
                        if(--indegree[i] == 0) {
                            queue.offer(t[i]);
                        }
                    }
                }
            }

            for(int i = 0; i < n; ++i) {
                System.out.print(res.get(i));
                if(i != n-1) System.out.print(" ");
            }
        }
    }
}

package BiShi.WeBank;

import java.io.File;
import java.util.*;

/**
 * @Author MaoTian
 * @Classname Main_3
 * @Description TODO
 * @Date 下午5:36 2019/9/19
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class Main_3 {

    //邻接表
    public static HashMap<Integer,List<Integer>> v=new HashMap<>();
    //保存路径
    public static List<Integer> path=new ArrayList<>();
    //所有可能的路径
    public static List<List<Integer>> res=new ArrayList<>();

    public  static void dfs(int B,int E){
        path.add(B);
        if(B==E){
            res.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return;//注意退出
        }
        for (int i = 0; i <v.get(B).size() ; i++) {
            //避免重复访问
            if(path.contains(v.get(B).get(i))){
                continue;
            }
            // B--->i---->E,通过中间节点到end
            dfs(v.get(B).get(i),E);
        }
        path.remove(path.size()-1);
    }

    public static void main(String[] args)throws Exception {
        Scanner sc =new Scanner(new File("/home/mao/workspace/面试/JavaGuide/JavaInterview/java/src/BiShi/WeBank/main_3"));
        //Scanner sc =new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            //记录所有的节点
            List<Integer>node=new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                node.add(a);
                node.add(b);

                //无向图，添加ab和ba
                if (v.containsKey(a)){
                    v.get(a).add(b);
                }else {
                    List<Integer> tmp=new ArrayList<>();
                    tmp.add(b);
                    v.put(a,tmp);
                }
                if (v.containsKey(b)){
                    v.get(b).add(a);
                }else {
                    List<Integer> tmp=new ArrayList<>();
                    tmp.add(a);
                    v.put(b,tmp);
                }
            }


            int B = sc.nextInt();
            int E = sc.nextInt();
            dfs(B, E);

            Set<Integer> set1=new HashSet<>();
            set1.addAll(node);
            Set<Integer> set2=new HashSet<>();

            for (List<Integer> l:res){
                for(Integer i:l){
                    set2.add(i);
                }
            }

            for (Integer i:set1){
                if(!set2.contains(i)){
                    System.out.print(i+" ");
                }
            }

        }
    }
}

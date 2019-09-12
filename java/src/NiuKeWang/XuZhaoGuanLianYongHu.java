package NiuKeWang;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @Classname XuZhaoGuanLianYongHu
 * @Description TODO
 * @Date 19-5-25 上午10:01
 * @Created by mao<tianmao818@qq.com>
 */
public class XuZhaoGuanLianYongHu {
    public static void main(String[] args)throws IOException {
        Scanner sc=new Scanner(new File("/home/mao/workspace/java/src/NiuKeWang/paypal"));
        //多组输入
        while (sc.hasNext()){
            double d=sc.nextDouble();
            int n=sc.nextInt();

            //建表
            List<List<Double>> table=new ArrayList<>();
            for(int i=0;i<n;i++){
                List<Double> tmp=new ArrayList<>();
                double x=sc.nextDouble();
                double y=sc.nextDouble();
                tmp.add(x);
                tmp.add(y);
                table.add(tmp);
            }

            //使用并查集
            int[] array=new int[n];
            for(int i=0;i<n;i++){
                array[i]=i;
            }


            //建图
            Map<Integer,List<Integer>> map=new HashMap<>();
            for(int i=0;i<n;i++){
                for(int j=i;j<n;j++){
                    double x1=table.get(i).get(0);
                    double y1=table.get(i).get(1);
                    double x2=table.get(j).get(0);
                    double y2=table.get(j).get(1);

                    double dd=distance(x1,y1,x2,y2);

                    if(dd<=d*d){

                        array[j]=array[i];


                        //正向
                        if(map.containsKey(i)){
                            map.get(i).add(j);
                        }else{
                            map.put(i,new ArrayList<>());
                            map.get(i).add(j);
                        }

                        //反向
                        if(map.containsKey(j)){
                            map.get(j).add(i);
                        }else{
                            map.put(j,new ArrayList<>());
                            map.get(j).add(i);
                        }
                    }
                }
            }
            List<List<Integer>> res=find(map);
            List<List<Integer>> ans=new ArrayList<>();
            for(List<Integer> tmp:res){
                tmp.sort(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1-o2;
                    }
                });
                ans.add(tmp);
            }

            ans.sort(new Comparator<List<Integer>>() {
                @Override
                public int compare(List<Integer> o1, List<Integer> o2) {
                    return o1.get(0)-o2.get(0);
                }
            });
            for (int i:array){
                System.out.println(i);
            }
            System.out.println(Arrays.asList(array));
            System.out.println(ans);
        }
    }

    public static double distance(double x1,double y1,double x2,double y2){
        return (x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);
    }

    public static List<List<Integer>> find(Map<Integer,List<Integer>> map){

        List<List<Integer>> ans=new ArrayList<>();
        int[] visited = new int[map.size()];

        for(int key :map.keySet()){
            List<Integer> tmp=new ArrayList<>();

            if(visited[key]==0){
                tmp.add(key);
                List<Integer> queue=new ArrayList<>();
                for(Integer i:map.get(key)){
                    queue.add(i);
                }
                visited[key]=1;
                while(!queue.isEmpty()){
                    int node=queue.get(0);
                    queue.remove(0);
                    if(visited[node]==0){
                        tmp.add(node);
                        for(Integer i:map.get(node)){
                            queue.add(i);
                        }
                        visited[node]=1;
                    }
                }
            }else {
                continue;
            }
            ans.add(tmp);
        }
        return ans;
    }


    public static List<List<Integer>> find(List<Integer> array){

        List<List<Integer>> ans=new ArrayList<>();

        return ans;
    }





}

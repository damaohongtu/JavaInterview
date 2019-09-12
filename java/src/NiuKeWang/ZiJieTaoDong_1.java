package NiuKeWang;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @Classname ZiJieTaoDong_1
 * @Description 仅仅通过了60%
 * @Date 19-5-23 下午1:49
 * @Created by mao<tianmao818@qq.com>
 */
public class ZiJieTaoDong_1{
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(new File("/home/mao/workspace/java/src/NiuKeWang/zijietiaodong_1"));

        while(sc.hasNext()){
            int n=sc.nextInt();
            HashMap<Integer,Integer> map=new HashMap<>();
            for(int i=0;i<n;i++){
                int x=sc.nextInt();
                int y=sc.nextInt();

                if(map.containsKey(x)){
                    if(map.get(x)<y){
                        map.put(x,y);
                    }
                }else{
                    map.put(x,y);
                }
            }

            int size=map.size();

            List<List<Integer>> a=new ArrayList<>();
            for(Integer x:map.keySet()){
                List<Integer> b=new ArrayList<>();
                b.add(x);
                b.add(map.get(x));
                a.add(b);
            }

            PriorityQueue<List<Integer>> queue=new PriorityQueue<>(new Comparator<List<Integer>>() {
                @Override
                public int compare(List<Integer> o1, List<Integer> o2) {
                    return o2.get(1)-o1.get(1);
                }
            });
            queue.addAll(a);

            List<Integer> aa=queue.poll();
            int flagX=aa.get(0);
            int flagY=aa.get(1);
            List<List<Integer>>res=new ArrayList<>();
            List<Integer> rr=new ArrayList<>();
            rr.add(flagX);
            rr.add(flagY);
            res.add(rr);
            while (!queue.isEmpty()){
                List<Integer> rrr=queue.poll();
                int X=rrr.get(0);
                int Y=rrr.get(1);
                if(X>flagX){
                    flagX=X;
                    res.add(rrr);
                }
            }
            res.sort(new Comparator<List<Integer>>() {
                @Override
                public int compare(List<Integer> o1, List<Integer> o2) {
                    return o1.get(0)-o2.get(0);
                }
            });
            for(List<Integer> r:res){
                System.out.print(r.get(0)+" ");
                System.out.println(r.get(1));
            }

        }

    }
}

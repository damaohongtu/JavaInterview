package WangNianZhenTI;

import java.io.File;
import java.util.*;

class Task implements Comparable<Task>{
    public int c;
    public int p;
    public Task(int c,int p){
        this.p=p;
        this.c=c;
    }

    @Override
    public int compareTo(Task o) {
        return this.c-o.c;
    }
}
public class WangYi_01 {
    public static void main(String[] args)throws Exception {
        Scanner sc=new Scanner(new File("/home/mao/workspace/java/src/WangNianZhenTI/test"));
        while(sc.hasNext()){
            int N=sc.nextInt();
            int M=sc.nextInt();

            List<Task> jobs=new ArrayList<>();

            List<Integer> peoples=new ArrayList<>();
            for(int i=0;i<N;i++){
                int a=sc.nextInt();
                int b=sc.nextInt();
                Task task=new Task(a,b);
                jobs.add(task);
            }
            Collections.sort(jobs,(a,b)->(a.c-b.c));

            for (int i=1;i<N;i++){
                if(jobs.get(i).p<jobs.get(i-1).p){
                    jobs.get(i).p=jobs.get(i-1).p;
                }
            }

            for(int j=0;j<M;j++){
                peoples.add(sc.nextInt());
            }
            for(int j=0;j<M;j++){
                int ans=0;
                int people=peoples.get(j);
                Task tmp=new Task(people,0);
//                int index=Collections.binarySearch(jobs,tmp,(a,b)->(a.c-b.c));
//                int index=Collections.binarySearch(jobs, tmp, new Comparator<Task>() {
//                    @Override
//                    public int compare(Task o1, Task o2) {
//                        return o1.c-o2.c;
//                    }
//                });

                int index=Collections.binarySearch(jobs, tmp);



                if(index>=0){
                    ans=jobs.get(index).p;
                }else {
                    if(index==-1){
                        ans=0;
                    }else{
                        index=-2-index;
                        ans=jobs.get(index).p;
                    }
                }
                System.out.println(ans);
            }

        }


    }
}

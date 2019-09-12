package WangNianZhenTI;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Point{
    int x;
    int y;
    int flag;
    public Point(int x,int y,int flag){
        this.x=x;
        this.y=y;
        this.flag=flag;
    }
}
public class ZuiDaDianJi {
    public static void main(String[] args)throws Exception {
        Scanner sc=new Scanner(new File("/home/mao/workspace/java/src/WangNianZhenTI/test"));
        while(sc.hasNext()){
            int N=sc.nextInt();
            List<Point> points=new ArrayList<>(N);
            for(int i=0;i<N;i++){
                int x=sc.nextInt();
                int y=sc.nextInt();
                points.add(new Point(x,y,0));
            }
            Collections.sort(points,(a,b)->{return a.x!=b.x?(a.x-b.x):(b.y-a.y);});

            for (int k=0;k<N;k++){
                System.out.println(points.get(k).x+" "+points.get(k).y);
            }

            points.get(N-1).flag=1;
            int tmp=points.get(N-1).y;
            for(int j=N-2;j>=0;j--){
                if (points.get(j).y>tmp){
                    points.get(j).flag=1;
                    tmp=points.get(j).y;
                    System.out.println(tmp);
                }
            }
            for (int k=0;k<N;k++){
                if(points.get(k).flag==1){
                    System.out.println(points.get(k).x+" "+points.get(k).y);
                }
            }
        }
    }
}

package ByteDancePreparation;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//4 100
//        100 73 60
//        100 89 35
//        30 21 30
//        10 8 10
class Game{
    int old;
    int latest;
    int happy;
    public Game(int old, int latest, int happy) {
        this.old = old;
        this.latest = latest;
        this.happy = happy;
    }
}
public class Main_4 {
    public static void main(String[] args)throws Exception {
        Scanner sc =new Scanner(new File("/home/mao/workspace/面试/JavaGuide/JavaInterview/java/src/ByteDancePreparation/main_4"));
        //Scanner sc =new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int budget=sc.nextInt();
            List<Game> records=new ArrayList<>();
            for(int i=0;i<n;i++){
                int a=sc.nextInt();
                int b=sc.nextInt();
                int c=sc.nextInt();
                records.add(new Game(a,b,c));
            }

        }
    }
}

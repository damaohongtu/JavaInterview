import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {

        Integer[] test={123,456,7,89,3,44};
        Arrays.sort(test, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1=o1.toString();
                String s2=o2.toString();
                return s1.compareTo(s2);
            }
        });
        for(Integer i:test){
            System.out.println(i);
        }
        System.out.println("Hello World!");
        PriorityQueue<Integer> tmp=new PriorityQueue<>(11, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        
    }
}

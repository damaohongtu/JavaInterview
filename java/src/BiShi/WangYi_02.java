package BiShi;

import java.util.Scanner;

public class WangYi_02 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int count=sc.nextInt();
        for(int i=0;i<count;i++){
            int n=sc.nextInt();
            int[] numbers=new int[n];
            for(int j=0;j<n;j++){
                numbers[i]=sc.nextInt();
            }
            System.out.println("NO");
        }
    }
}

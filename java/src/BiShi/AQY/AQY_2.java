package BiShi.AQY;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class AQY_2 {


    public static double dp(double n,double m){
        if(n==0)return 0;
        if(m==0)return 1;
        if(m==1){
            return n/(n+1.0);
        }
        if(m==2){
            return n/(n+2.0);
        }
        double res=n/(m+n) + (m/(m+n))*((m-1)/(m+n-1))*((m-2)/(m+n-2))*dp(n,m-3);
        res += (m/(m+n))*(m-1)/(m+n-1)*(n/(m+n-2))*dp(n-1,m-2);
        return res;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc=new Scanner(new File("/home/mao/workspace/java/src/BiShi/AQY/test2"));
        //Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            double n=sc.nextDouble();
            double m=sc.nextDouble();
            double res=dp(n,m);

            DecimalFormat df = new DecimalFormat("#0.00000");
            System.out.println(df.format(res));
        }
    }
}

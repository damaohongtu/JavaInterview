package NiuKeWang;/**
 * @Classname NthPrime
 * @Description TODO
 * @Date 19-3-17 上午10:39
 * @Created by mao<tianmao818@qq.com>
 */
import java.util.Scanner;
public class NthPrime {

        public static boolean isPrime(int n){
            for(int i=2;i<=Math.sqrt(n);i++)
            {
                if(n%i==0){
                    return false;
                }
            }
            return true;
        }

        public static void main(String[] args) {

            Scanner in=new Scanner(System.in);
            while(in.hasNext()){
                int n=in.nextInt();
                int count=0;
                int i=0;
                for( i=2;i<=1000;i++){
                    if(isPrime(i)){
                        count++;
                    }
                    if(count==n) break;
                }
                System.out.println(i);

            }
        }

    }
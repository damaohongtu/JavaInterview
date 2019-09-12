package NiuKeWang;/**
 * @Classname Test
 * @Description TODO
 * @Date 19-3-17 下午3:03
 * @Created by mao<tianmao818@qq.com>
 */
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
public class Test{
    public static void main(String[] args)throws IOException{
        InputStreamReader ir=new InputStreamReader(System.in);

        BufferedReader bf=new BufferedReader(ir);
        int n=Integer.parseInt(bf.readLine());
        String[] s=bf.readLine().split(" ");


        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=Integer.parseInt(s[i]);
        }
        if(nums.length==1){
            System.out.print(nums[0]);
            return;
        }
        if(nums.length==2){
            System.out.print(nums[1]+" ");
            System.out.print(nums[0]);
            return;
        }
        if(n%2==0){
            for(int i=n-1;i>0;i=i-2){
                System.out.print(nums[i]+" ");
            }
            for(int j=0;j<n-2;j=j+2){
                System.out.print(nums[j]+" ");
            }
            System.out.print(nums[n-2]);
        }else{
            for(int i=n-1;i>=0;i=i-2){
                System.out.print(nums[i]+" ");
            }
            for(int j=1;j<n-2;j=j+2){
                System.out.print(nums[j]+" ");
            }
            System.out.print(nums[n-2]);
        }
    }
}
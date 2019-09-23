package BiShi.ZiJie;

import java.io.File;
import java.util.Scanner;

/**
 * @Author MaoTian
 * @Classname Main_1
 * @Description TODO
 * @Date 上午8:00 2019/9/22
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class Main_1 {
    public static void main(String[] args)throws Exception {
        Scanner sc =new Scanner(new File("/home/mao/workspace/专业/JavaGuide/JavaInterview/java/src/BiShi/ZiJie/main_1"));
        //Scanner sc =new Scanner(System.in);
        while(sc.hasNext()){
            int N=Integer.parseInt(sc.next());
            char[] arr=new char[N];
            int[] res=new int[N];
            String s=sc.next();
            arr=s.toCharArray();

            for (int i = 0; i <N ; i++) {
                if(arr[i]=='O'){
                    res[i]=0;
                }else {
                    int tmp1=i;
                    int tmp2=i;
                    int flag1=0;
                    int flag2=0;

                    while (tmp1>=0){
                        if(arr[tmp1]=='O'){
                            flag1=1;
                            break;
                        }else {
                            tmp1--;
                        }
                    }
                    while (tmp2<N){
                        if(arr[tmp2]=='O'){
                            flag2=0;
                            break;
                        }else {
                            tmp2++;
                        }
                    }

                    if(flag1==1 && flag2==1){
                        res[i]=Math.min(i-tmp1,tmp2-i);
                    }else if(flag1==1 && flag2==0){
                        res[i]=i-tmp1;
                    }else {
                        res[i]=tmp2-i;
                    }
                }
            }

            for (int i = 0; i <N-1 ; i++) {
                System.out.print(res[i]+" ");
            }
            System.out.println(res[N-1]);
        }
    }
}

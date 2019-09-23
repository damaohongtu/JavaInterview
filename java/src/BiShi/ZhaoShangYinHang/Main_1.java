package BiShi.ZhaoShangYinHang;

import java.io.File;
import java.util.Scanner;

/**
 * @Author MaoTian
 * @Classname Main_1
 * @Description TODO
 * @Date 下午7:16 2019/9/15
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class Main_1 {
    public static void main(String[] args)throws Exception {
        Scanner sc =new Scanner(new File("/home/mao/workspace/面试/JavaGuide/JavaInterview/java/src/BiShi/ZhaoShangYinHang/main_1"));
        //Scanner sc =new Scanner(System.in);
        while(sc.hasNext()){
            String direc=sc.nextLine();
            int length=direc.length();

            int[] array=new int[length];
            int total=0;

            for(int i=0;i<length;i++){
                if(direc.charAt(i)=='L'){
                    if(total!=0){
                        array[i-1]=total>>1;
                        array[i]=total>>1;
                        if(total%2==1){
                            array[i-1]+=1;
                        }
                    }
                    array[i]+=1;
                    total=0;
                }else {
                    total++;
                }
            }

            for (int i = length-1; i >=0 ; i--) {
                if(direc.charAt(i)=='R'){
                    if(total!=0){
                        array[i]+=total>>1;
                        array[i+1]+=total>>1;
                        if(total%2==1){
                            array[i+1]+=1;
                        }
                    }
                    total=0;
                }else{
                    total++;
                }
            }


            for (int i = 0; i <length ; i++) {
                if (i!=length-1){
                    System.out.print(array[i]+" ");
                }else {
                    System.out.println(array[i]);
                }
            }





        }
    }
}

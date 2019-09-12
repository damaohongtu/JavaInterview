package BiShi.BZ;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author MaoTian
 * @Classname BZ_4
 * @Description TODO
 * @Date 下午6:24 2019/9/10
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
class Node{
    int a;
    int b;
    Node(int a,int b){
        this.a=a;
        this.b=b;
    }
}
public class BZ_4 {


    public static void main(String[] args)throws Exception {
        Scanner sc =new Scanner(new File("/home/mao/workspace/java/src/BiShi/BZ/test4"));
        //Scanner sc =new Scanner(System.in);
        while(sc.hasNext()){

            int n=sc.nextInt();
            int[] a=new int[n];
            int[] b=new int[n];

            //货物的总数
            int s=0;

            //保存ai
            for (int i = 0; i <n ; i++) {
                a[i]=sc.nextInt();
                s+=a[i];
            }

            //保存bi
            for (int j = 0; j <n ; j++) {
                b[j]=sc.nextInt();
            }

            //将ai和bi绑在一起
            Node[] tmp=new Node[n];
            for (int k = 0; k <n ; k++) {
                tmp[k]=new Node(a[k],b[k]);
            }

            //按照bi排序
            Arrays.sort(tmp,(x,y)->(y.b-x.b));
            int count=0;
            //最后一个箱子装的数量
            int last=0;
            for(int m=0;m<n;m++){
                if(s>0){
                    last=s;
                    s-=tmp[m].b;
                    count++;
                }else{
                    break;
                }
            }
            //时间
            int time=0;
            for (int i=0;i<count-1;i++){
                time+=(tmp[i].b-tmp[i].a);
            }
            //最后一个箱子时间特殊处理
            time+=last-tmp[count-1].a;
            System.out.println(count+" "+time);
        }
    }
}

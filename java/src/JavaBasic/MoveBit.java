package JavaBasic;

import java.util.Random;

/**
 * @Classname MoveBit
 * @Description TODO
 * @Date 19-7-15 上午10:41
 * @Created by mao<tianmao818@qq.com>
 */
public class MoveBit {
    public static void main(String[] args){
//        int flag=1;
//        while (flag!=0){
//            flag=flag<<1;
//            System.out.println(flag);
//        }

        Random random=new Random(818);
        for(int i=0;i<5;i++){
            System.out.println(random.nextGaussian());
            System.out.println(random.nextInt(500));
            System.out.println(random.nextDouble());
            System.out.println(Math.random());
        }

    }
}

package JianZhiOffer;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Classname Josephuse
 * @Description TODO
 * @Date 19-3-5 下午1:58
 * @Created by mao<tianmao818@qq.com>
 */
public class Josephuse {
    int lastRemain(int n,int m){
        if(n<0 || m<1){
            return -1;
        }
        List<Integer> numbers=new LinkedList<>();
        for(int i=0;i<n;i++){
            numbers.add(i);
        }
        Iterator<Integer> current=numbers.iterator();
        while (numbers.size()>1){
            for(int j=0;j<m;j++){
                if(current.hasNext()){
                    current.next();
                }else {
                    current=numbers.iterator();
                    current.next();
                }
            }
            current.remove();
        }
        return numbers.get(0);
    }
    int lastRemain2(int n,int m){
        if(n<1 || m<1){
            return -1;
        }
        int last=0;
        for(int i=2;i<=n;i++){
            last=(last+m)%i;
        }
        return last;
    }
    public static void main(String[] args){
        Josephuse josephuse=new Josephuse();
        System.out.println(josephuse.lastRemain(10,5));
        System.out.println(josephuse.lastRemain2(10,5));
    }
}
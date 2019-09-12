package ALiBaBa;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @Author MaoTian
 * @Classname PaiLie
 * @Description TODO
 * @Date 上午10:01 2019/8/17
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class PaiLie {

    public ArrayList<String> permutation(String s){
        ArrayList<String> list=new ArrayList<>();
        char[] arr=s.toCharArray();
        helper(arr,0,list);
        return list;
    }
    public  void helper(char[] arr,int start,ArrayList<String> list) {
        if(start==arr.length-1){
            if(!list.contains(String.valueOf(arr))){
                list.add(String.valueOf(arr));
            }
        }else{
            for(int i=start;i<arr.length;i++){
                char tmp=arr[start];
                arr[start]=arr[i];
                arr[i]=tmp;
                helper(arr,start+1,list);
                arr[i]=arr[start];
                arr[start]=tmp;
            }
        }

    }

    @Test
    public void check(){
        ArrayList<String> ans=permutation("123");
        for (int i = 0; i < ans.size() ; i++) {
            System.out.println(ans.get(i));
        }
    }
}

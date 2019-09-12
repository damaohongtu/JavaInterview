package LeetCode;

import java.util.HashMap;

/**
 * @Classname StringCompression
 * @Description TODO
 * @Date 19-2-28 上午9:13
 * @Created by mao<tianmao818@qq.com>
 */
public class StringCompression {
    public int compress(char[] chars) {
        int result=0;
        HashMap<Character,Integer>count=new HashMap<>();
        for(int i=0;i<chars.length;i++){
            if(count.containsKey(chars[i])){
                count.put(chars[i],count.get(chars[i])+1);
            }else {
                count.put(chars[i],1);
            }
        }
        for (Character x:count.keySet()){
            int temp=count.get(x);
            if(temp==1){
                result+=1;
            }else{
                result+=getBit(temp)+1;
            }
        }
        return result;
    }
    public int getBit(int num){
        int result=0;
        while(num!=0){
            result++;
            num=num/10;
        }
        return result;
    }
    public static void main(String[] args){
        char[] test={'a','a','b','b','c','c','c'};
        StringCompression stringCompression=new StringCompression();
        System.out.println(stringCompression.compress(test));
    }
}
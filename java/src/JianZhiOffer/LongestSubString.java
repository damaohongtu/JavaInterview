package JianZhiOffer;

import java.util.HashMap;

/**
 * @Classname LongestSubString
 * @Description 获取最长的不重复的子字符串
 * @Date 19-3-5 上午11:09
 * @Created by mao<tianmao818@qq.com>
 */
public class LongestSubString {
    public int getLongestSubString(String s){
        int curLength=0;
        int maxLength=0;
        HashMap<Integer,Integer> position=new HashMap<>();
        for(int i=0;i<26;i++){
            position.put(i,-1);
        }
        for(int i=0;i<s.length();i++){
            int preIndex=position.get(s.charAt(i)-'a');
            if(preIndex<0 || i-preIndex>curLength){
                curLength++;
            }else{
                if(curLength>maxLength){
                    maxLength=curLength;
                }
                curLength=i-preIndex;
            }
            position.put(s.charAt(i)-'a',i);
        }
        if(curLength>maxLength){
            maxLength=curLength;
        }
        return maxLength;
    }
    public static void main(String[] args){
        LongestSubString longestSubString=new LongestSubString();
        System.out.println(longestSubString.getLongestSubString("araabbcacfr"));
    }
}
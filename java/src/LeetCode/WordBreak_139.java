package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname WordBreak_139
 * @Description 切分字符串,要刚刚好切分为字典中的单词
 * 解法:
 * @Date 19-5-10 下午11:01
 * @Created by mao<tianmao818@qq.com>
 */
public class WordBreak_139 {

    public static boolean wordBreak(String s, List<String> wordDict) {
        int len=s.length()+1;
        boolean[] flags=new boolean[len];
        flags[0]=true;
        for(int i=1;i<len;i++){
            for(int j=i-1;j>=0;j--){
                if(flags[j]&&wordDict.contains(s.substring(j,i))){
                    flags[i]=true;
                    break;
                }
            }
        }
        return flags[len-1];
    }
    public static void main(String[] args){
        List<String> wordDict=new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        String s="leetcode";
        boolean result=wordBreak(s,wordDict);
        System.out.print(result);
    }

}

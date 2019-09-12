package CommonProblems.StringProblems;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author MaoTian
 * @Classname LeetCode784
 * @Description 大小写排列
 * @Date 上午10:13 2019/8/27
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class LeetCode784 {
    public List<String> letterCasePermutation(String S) {
        List<String> res=new ArrayList<>();
        if(S.length()==0){
            return res;
        }
        Character c0=S.charAt(0);
        if(Character.isLetter(c0)){
            res.add(""+Character.toUpperCase(c0));
            res.add(""+Character.toLowerCase(c0));
        }else{
            res.add(""+c0);
        }
        for(int j=1;j<S.length();j++){
            Character c=S.charAt(j);
            int len=res.size();
            if(Character.isLetter(c)){
                res.addAll(res);
                for (int i = 0; i < len; i++) {
                    res.set(i,res.get(i)+Character.toUpperCase(c));
                }
                for (int i = len; i < 2*len; i++) {
                    res.set(i,res.get(i)+Character.toLowerCase(c));
                }
            }else{
                for (int i = 0; i < len; i++) {
                    res.set(i,res.get(i)+c);
                }
            }
        }
        return res;
    }


    public List<String> letterCasePermutation2(String S) {
        List<String> ans = new ArrayList<String>();
        dg(S.toCharArray(),0,ans);
        return ans;
    }
    public void dg(char[] s,int i,List<String> ans){
        if(i==s.length){
            ans.add(String.valueOf(s));
            return;
        }
        dg(s,i+1,ans);
        if(s[i]<'0'||s[i]>'9'){
            s[i]^=(1<<5);
            dg(s,i+1,ans);
        }

    }

}

package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>>result=new ArrayList<>();
        HashMap<String,List<String>> res=new HashMap<>();
        for (String s:strs){
            List<String> t=getAnagrams(s);
            int flag=0;
            for(String tt:t){
                if(res.keySet().contains(tt)){
                    res.get(tt).add(s);
                    flag=1;
                    break;
                }
            }
            if(flag==0){
                List<String> l=new ArrayList<>();
                l.add(s);
                res.put(s,l);
            }
        }
        result.addAll(res.values());
        return result;
    }
    public List<String> getAnagrams(String s){
        List<String> temp=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            temp.add(s.substring(i)+s.substring(0,i));
        }
        String s2=new StringBuffer(s).reverse().toString();
        temp.add(s2);
        for(int i=0;i<s.length();i++){
            temp.add(s.substring(i)+s.substring(0,i));
        }
        return temp;
    }
    public static void main(String[] args){
        GroupAnagrams groupAnagrams=new GroupAnagrams();
        String [] test={"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams.groupAnagrams(test));
    }

}

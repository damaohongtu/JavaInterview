package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    private List<String> res=new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        return res;
    }
    public void helper(String s,String temp,int position){
        if(position>=s.length()){
            res.add(temp);
        }
        temp+=".";
        helper(s,temp,position+1);

    }
}

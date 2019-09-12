package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @Classname SimplifyPath
 * @Description TODO
 * @Date 19-2-27 下午2:33
 * @Created by mao<tianmao818@qq.com>
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        List<String> path2=new ArrayList<String>();
        String[] temp=path.split("/");
        for(String t:temp){
            if(t.length()!=0 && !t.equals(".")){
                path2.add(t);
            }
        }
        Stack<String>stack=new Stack<>();
        for (int i=0;i<path2.size();i++){
            if(!path2.get(i).equals("..")){
                stack.push(path2.get(i));
            }else if(!stack.isEmpty()){
                stack.pop();
            }
        }
        List<String> path3=new ArrayList<>();
        for(String x:stack){
            path3.add(x);
        }
        String result="/";
        for(int i=0;i<path3.size()-1;i++){
            result+=(path3.get(i)+"/");
        }
        result+=path3.get(path3.size()-1);
        return result;
    }
    public static void main(String[] args){
        SimplifyPath simplifyPath=new SimplifyPath();
        System.out.println(simplifyPath.simplifyPath("/home//foo/"));
    }
}
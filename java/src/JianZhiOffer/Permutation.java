package JianZhiOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Permutation
 * @Description TODO
 * @Date 19-3-4 上午9:47
 * @Created by mao<tianmao818@qq.com>
 */
public class Permutation {
    private List<List<Character>> res=new ArrayList<>();
    public List<List<Character>> permutate(String s){
        permutateCore(s,0,new ArrayList<>());
        return res;
    }
    public void permutateCore(String s,int start,List<Character> list){
        int length=s.length();
        if(list.size()==length){
            res.add(list);
        }
        if(start>=length){
            return;
        }
        for (int i=0;i<length;i++){
            if(list.contains(s.charAt(i))){
                continue;
            }
            list.add(s.charAt(i));
            permutateCore(s,i,new ArrayList<>(list));
            list.remove(list.size()-1);
        }
    }
    public static void main(String[] args){
        String test="mao&yun";
        Permutation permutation=new Permutation();
        System.out.println(permutation.permutate(test));
    }
}
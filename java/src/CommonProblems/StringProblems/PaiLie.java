package CommonProblems.StringProblems;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @Author MaoTian
 * @Classname PaiLie
 * @Description 字符串的排列
 * @Date 下午4:59 2019/8/15
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class PaiLie {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<String>();
        if(str==null || str.length()==0)
            return list;
        helper(str.toCharArray(),0,list);
        Collections.sort(list);  //将list中的字符串排序
        return list;
    }

    private void helper(char[] strArray,int index,ArrayList<String> list){
        if(index==strArray.length-1){
            if(!list.contains(String.valueOf(strArray)))  //判断是否有重复字符串
                list.add(String.valueOf(strArray));
        }else{
            for(int i=index;i<strArray.length;i++){

                char temp=strArray[index];
                strArray[index]=strArray[i];
                strArray[i]=temp;

                helper(strArray,index+1,list);

                strArray[i]=strArray[index];
                strArray[index]=temp;
            }
        }
    }

}

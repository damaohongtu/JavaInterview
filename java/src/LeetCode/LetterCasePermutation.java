package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    private static List<String> res=new ArrayList<>();
    public static List<String> letterCasePermutation(String S) {
        helper(S,"",0);
        return res;
    }
    public static void helper(String S,String currentString,int startIndex){
        if (currentString.length()==S.length()){
            res.add(currentString);
        }else {
            final char currentChar=S.charAt(startIndex);
            if(Character.isLetter(currentChar)){
                helper(S,currentString+Character.toLowerCase(currentChar),startIndex+1);
                helper(S,currentString+Character.toUpperCase(currentChar),startIndex+1);
            }else {
                helper(S,currentString+currentChar,startIndex+1);
            }
        }
    }
    public static void main(String[] args){
        String S="a1b2";
        System.out.println(letterCasePermutation(S));
    }
}

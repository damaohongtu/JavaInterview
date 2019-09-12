package LeetCode;/**
 * @Classname DetectCapital
 * @Description TODO
 * @Date 19-2-28 上午10:00
 * @Created by mao<tianmao818@qq.com>
 */
public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        if(word.length()==1){
            return true;
        }
        if(word.equals(word.toLowerCase())||word.equals(word.toUpperCase())){
            return true;
        }else if(word.charAt(0)>='A' && word.charAt(0)<='Z'){
            String temp=word.substring(1);
            if(temp.equals(temp.toLowerCase())||temp.equals(temp.toUpperCase())){
                return true;
            }else {
                return false;
            }
        }else{
            return false;
        }

    }
}
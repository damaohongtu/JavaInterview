package LeetCode;/**
 * @Classname ReverseWords
 * @Description TODO
 * @Date 19-2-27 下午1:55
 * @Created by mao<tianmao818@qq.com>
 */
public class ReverseWords {
    public String reverseWords(String s) {
        s=s.trim();
        String [] arrs=s.split("\\s+");
        String result="";
        System.out.println(arrs.length);

        for(int i=arrs.length-1;i>0;i--){
            System.out.println(arrs[i]);
            result+=(arrs[i]+" ");
        }
        result+=arrs[0];
        return result;
    }
    public static void main(String[] args){
        ReverseWords reverseWords=new ReverseWords();
        System.out.println(reverseWords.reverseWords("  hello    world!  "));
    }
}
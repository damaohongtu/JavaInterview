package LeetCode;/**
 * @Classname DecodeWays
 * @Description 本题和爬楼梯题目是相似的,应该考虑使用递归思想
 * @Date 19-2-27 下午3:36
 * @Created by mao<tianmao818@qq.com>
 */
public class DecodeWays {
    public int numDecodings(String s) {

        int result=0;
        if(s.length()==0){
            return 0;
        }
        if(s.length()==1){
            return 1;
        }
        if(s.length()==2){
            int a=s.charAt(0)-'0';
            int b=s.charAt(1)-'0';
            int num=a*10+b;
            if(num>26){
                return 1;
            }else {
                return 2;
            }
        }
        if(s.length()>2){
            for(int i=s.length()-1;i>=2;i--){
                int a2=s.charAt(i)-'0';
                int b2=s.charAt(i-1)-'0';
                int num2=a2+b2*10;
                if(num2<=26){
                    result=numDecodings(s.substring(0,i))+numDecodings(s.substring(0,i-1));
                }else{
                    result=numDecodings(s.substring(0,i));
                }
            }
        }

        return result;
    }
    public static void main(String[] args){
        DecodeWays decodeWays=new DecodeWays();
        System.out.println(decodeWays.numDecodings("27"));
    }

}
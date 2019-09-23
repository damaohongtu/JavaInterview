package CommonProblems.Dynamic;/**
 * @Classname MaxCLS
 * @Description 最长公共字符串
 * @Date 19-7-21 下午1:28
 * @Created by mao<tianmao818@qq.com>
 */
public class MaxCLS {
    public static int maxCLS(String s1,String s2){
        int len1=s1.length()+1;
        int len2=s2.length()+1;
        int[][]ans =new int[len1][len2];

        char[] chr1=new char[len1];
        char[] chr2=new char[len2];

        int i=0;
        for(char c:s1.toCharArray()){
            chr1[++i]=c;
        }
        int j=0;
        for(char c:s2.toCharArray()){
            chr2[++j]=c;
        }

        for(i=0;i<len1;i++){
            ans[i][0]=0;
        }
        for(j=0;j<len2;j++){
            ans[0][j]=0;
        }

        for(i=1;i<len1;i++){
            for(j=1;j<len2;j++){
                if(chr1[i]==chr2[j]){
                    ans[i][j]=ans[i-1][j-1]+1;
                }else {
                    ans[i][j]=Math.max(ans[i-1][j],ans[i][j-1]);
                }
            }
        }

        return ans[len1-1][len2-1];
    }
    public static void main(String[] args){
        String s1="aaaaaaaaaaaaaa";
        String s2="bbbbbbbbbbbbbbbb";
        System.out.println(maxCLS(s1,s2));
    }
}

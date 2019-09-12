package CommonProblems.StringProblems;

/**
 * @Author MaoTian
 * @Classname ZuiChangGongGongZiXuLie
 * @Description 最长公共子序列
 * @Date 下午1:08 2019/8/15
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class ZuiChangGongGongZiXuLie {
    public int findLCS(String s1,String s2){

        int m= s1.length();
        int n=s2.length();
        int[][] max=new int[m+1][n+1];

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    max[i][j]=max[i-1][j-1]+1;
                }else {
                    max[i][j]=Math.max(max[i][j-1],max[i-1][j]);
                }
            }
        }

        return max[m][n];
    }

    public static void main(String[] args) {
        ZuiChangGongGongZiXuLie z=new ZuiChangGongGongZiXuLie();
        String s1="123456";
        String s2="234126";
        System.out.println(z.findLCS(s1,s2));
    }






}

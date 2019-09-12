package CommonProblems.StringProblems;

/**
 * @Author MaoTian
 * @Classname ZuiChangGongGongZiChuan
 * @Description
 * @Date 下午1:11 2019/8/15
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class ZuiChangGongGongZiChuan {
    public int getMaxCommon(String s1,String s2){

        int[][]max=new int[s1.length()+1][s2.length()+1];

        for(int i=1;i<=s1.length();i++){
            for (int j=1;j<=s2.length();j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    max[i][j]=max[i-1][j-1]+1;
                }else {
                    max[i][j]=0;
                }
            }
        }

        int res=0;
        for (int i=0;i<=s1.length();i++){
            for (int j=0;j<=s2.length();j++){
                if(max[i][j]>res){
                    res=max[i][j];
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        ZuiChangGongGongZiChuan z=new ZuiChangGongGongZiChuan();
        System.out.println(z.getMaxCommon("1234","2345"));
    }
}

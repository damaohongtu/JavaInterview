package MianJing.weiruan;/**
 * @Classname ZuiChengHuiWen
 * @Description
 * @Date 19-7-20 下午9:31
 * @Created by mao<tianmao818@qq.com>
 */
public class ZuiChengHuiWen {
    public static int[] getMax(String s,int l, int r){
        int len=s.length();
        while(0<=l && r<len && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        int[] res=new int[2];
        res[0]=l+1;
        res[1]=r-l-1;
        return res;
    }
    public static String getMaxPar(String S){
        int len=S.length();
        int maxlen=0;
        int start=0;
        int[] tmp=new int[2];
        for(int i=0;i<len;i++){
            tmp=getMax(S,i,i);
            if(tmp[1]>maxlen){
                start=tmp[0];
                maxlen=tmp[1];
            }
        }
        for(int i=0;i<len-1;i++){

            tmp=getMax(S,i,i+1);
            if(tmp[1]>maxlen){
                start=tmp[0];
                maxlen=tmp[1];
            }
        }
        return S.substring(start,start+maxlen);
    }
    public static void main(String[] args){
        String test="bcaaaaaaaaaacb";
        System.out.println(getMaxPar(test));
    }
}

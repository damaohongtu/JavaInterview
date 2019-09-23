package BiShi.ZiJie;

import java.io.File;
import java.util.*;

public class Main_4 {

    public static ArrayList<String> permutation(String str) {
        ArrayList<String> list = new ArrayList<String>();
        if(str==null || str.length()==0)
            return list;
        helper(str.toCharArray(),0,list);
        Collections.sort(list);  //将list中的字符串排序
        return list;
    }

    private static void helper(char[] strArray,int index,ArrayList<String> list){
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

    public static  int getK(String s){
        char[] tmp=s.toCharArray();
        int n=tmp.length;

        for (int i = 1; i <=n ; i++) {
            int flag=0;
            for (int j=0;j<n;j++){
                if (tmp[j]!=tmp[j%i]){
                    flag=1;
                    break;
                }
            }
            if(flag==0){
                return i;
            }
        }
        return 0;
    }

    public static int getCount(int a,int b){
        String s="";
        for (int i = 0; i <a ; i++) {
            s+="A";
        }
        for (int i = 0; i <b ; i++) {
            s+="B";
        }
        List<String> arr=permutation(s);

        HashSet<Integer>res=new HashSet<>();

        for (String t:arr){
            int k=getK(t);
            res.add(k);
        }
        return res.size();
    }
    public static void main(String[] args)throws Exception {
        Scanner sc =new Scanner(new File("/home/mao/workspace/专业/JavaGuide/JavaInterview/java/src/BiShi/ZiJie/main_4"));
        //Scanner sc =new Scanner(System.in);
        while(sc.hasNext()){
            int a=sc.nextInt();
            int b=sc.nextInt();
            System.out.println(getCount(a,b));
        }
    }
}

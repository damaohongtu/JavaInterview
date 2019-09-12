package JianZhiOffer;/**
 * @Classname CutLineMaxMul
 * @Description TODO
 * @Date 19-3-2 下午2:13
 * @Created by mao<tianmao818@qq.com>
 */
public class CutLineMaxMul {
    public int cut1(int n){
        if(n==0 || n==1 || n==2 || n==3){
            return n;
        }
        int []nums=new int[n+1];
        nums[0]=1;
        nums[1]=1;
        nums[2]=2;
        nums[3]=3;
        for(int i=4;i<=n;i++){
            nums[i]=max(nums[i-3]*3,nums[i-2]*2);
        }

        return nums[n];
    }
    public int cut2(int n){
        if(n==0 || n==1 || n==2){
            return n;
        }
        int timesOf3=n/3;
        if(n%3==1){
            timesOf3-=1;
        }
        int timesOf2=(n-3*timesOf3)/2;
        int res=1;
        while (timesOf3>0){
            res*=3;
            timesOf3--;
        }
        while (timesOf2>0){
            res*=2;
            timesOf2--;
        }
        return res;
    }
    public int max(int a,int b){
        return a>b?a:b;
    }
    public static void main(String[] args){
        CutLineMaxMul cutLineMaxMul=new CutLineMaxMul();
        System.out.println(cutLineMaxMul.cut1(50));
        System.out.println(cutLineMaxMul.cut2(50));
    }
}
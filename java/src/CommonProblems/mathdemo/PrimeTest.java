package CommonProblems.mathdemo;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author MaoTian
 * @Classname PrimeTest
 * @Description 素数筛法
 * @Date 下午7:20 2019/8/14
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class PrimeTest {
    public static void main(String[] args) {
        int[] nums=new int[1000];

        List<Integer> res=new ArrayList<>();
        for(int i=2;i<1000;i++){
            if(nums[i]==1){
                continue;
            }
            //新的素数
            res.add(i);
            for(int j=i*i;j<1000;j+=i){
                nums[j]=1;
            }
        }

        System.out.println(res.size());
        for(Integer k:res){
            System.out.print(k+" ");
        }
    }
    @Test
    public void test(){
        Assert.assertEquals(1,1);
    }
    @Test
    public void tes2(){
        Assert.assertEquals(1,2);
    }

}

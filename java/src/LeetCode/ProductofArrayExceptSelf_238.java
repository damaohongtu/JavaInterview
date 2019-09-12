package LeetCode;/**
 * @Classname ProductofArrayExceptSelf_238
 * @Description 求解除了自身之外的乘积
 * 思路: (1)连乘相除
 * (2) 左右分别走一遍!!!!!厉害,厉害了!
 * @Date 19-5-20 下午3:44
 * @Created by mao<tianmao818@qq.com>
 */
public class ProductofArrayExceptSelf_238 {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int tmp = 1;

        //To obtain LHS product
        for(int i=0;i<nums.length;i++)
        {
            result[i] = tmp;
            tmp *= nums[i];
        }
        tmp = 1;
        //To obtain RHS product
        for(int i=nums.length-1;i>=0;i--)
        {
            result[i] *= tmp;
            tmp *= nums[i];
        }

        return result;
    }
}

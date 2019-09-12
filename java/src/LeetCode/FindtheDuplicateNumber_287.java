package LeetCode;/**
 * @Classname FindtheDuplicateNumber_287
 * @Description 寻找重复的那一个数字
 * 思路: hash表格
 * @Date 19-5-20 下午4:57
 * @Created by mao<tianmao818@qq.com>
 */
public class FindtheDuplicateNumber_287 {
    public int findDuplicate(int[] nums) {

        int [] count=new int[nums.length];
        for(int i:nums){
            if(count[i]!=0){
                return i;
            }
            count[i]++;
        }
        return -1;
    }
}

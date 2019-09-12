package LeetCode;

import java.util.*;

/**
 * @Classname CoinChange
 * @Description TODO
 * @Date 19-2-28 下午1:38
 * @Created by mao<tianmao818@qq.com>
 */
public class CoinChange {
    private HashMap<Integer,Integer> num=new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        int result=-1;
        if(amount<0){
            return -1;
        }
        List<Integer> temp=new ArrayList<>();

        for(int i=0;i<coins.length;i++){
            if(amount==coins[i]){
                return 1;
            }
            int money=amount-coins[i];
            int x=0;
            if(num.keySet().contains(money)){
                x=num.get(money);
            }else {
                x=coinChange(coins,money);
                num.put(money,x);
            }
            if(x>0){
                temp.add(x);
            }
        }
        if(!temp.isEmpty()){
            result= Collections.min(temp)+1;
        }


        return result;
    }
    public static void main(String[] args){
        CoinChange coinChange=new CoinChange();
        int[] coins={2};
        System.out.println(coinChange.coinChange(coins,100));
    }
}
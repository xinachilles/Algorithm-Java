import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by xhu on 12/10/16.
 */
public class CoinChange {

    // coin change
    public int coinChange(int[] coins, int amount)
    {
        if (coins == null || coins.length == 0 || amount <= 0)
        {
            return 0;
        }

        int[] dp = new int[amount + 1];


        dp[0] = 0;
        //dp[i] means the fewest number of conin to make up the amount i

        for (int i = 1; i <= amount; i++)
        {
                int count = Integer.MAX_VALUE;
                for (int c : coins)
                {
                    if (i >= c && dp[i - c] + 1 < count)
                    {
                        count = dp[i - c] + 1;
                    }
                }

                dp[i] = count;

            }



        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];

    }

    public int coinChange2(int [] coins, int amount){
        if(coins == null || coins.length == 0){
            return 0;
        }
        Map<Integer,Integer> maps = new HashMap<>();
        //return help(coins,amount,0,maps);
        return -1;
    }

    public int help(int[] coins, int amount,Map<Integer,Integer>maps){

        if(maps.containsKey(amount) && maps.get(amount)!=Integer.MAX_VALUE){
            return maps.get(amount);
        }

        if(amount == 0){
            return 0;
        }

        int result = Integer.MAX_VALUE;
        for(int c : coins){
            if(amount>=c) {
                int r = help(coins, amount - c,maps);
                result = Math.min(result, r+1);
            }
        }

        maps.put(amount,result);
        return maps.get(amount);
    }

}

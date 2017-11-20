import java.util.HashSet;

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
}

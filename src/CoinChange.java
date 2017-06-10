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
        HashSet<Integer> coinSet = new HashSet<Integer>();

        for (int c : coins)
        {
            coinSet.add(c);
        }

        for (int i = 1; i <= amount; i++)
        {
            dp[i] = Integer.MAX_VALUE;
        }

        dp[0] = 0;
        //dp[i] means the fewest number of conin to make up the amount i

        for (int i = 1; i <= amount; i++)
        {
            if (coinSet.contains(i))
            {
                dp[i] = 1;
            }
            else
            {
                for (int c : coinSet)
                {
                    if (i >= c && dp[i-c ] < Integer.MAX_VALUE && dp[i - c] + 1 < dp[i])
                    {
                        dp[i] = dp[i - c] + 1;
                    }
                }

            }
        }


        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];

    }
}

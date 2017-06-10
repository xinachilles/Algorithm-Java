/**
 * Created by xhu on 10/23/16.
 */
public class BestTimeBuySellStock {
    // best time to buy i
    public int maxProfit(int[] prices)
    {
        if (prices == null || prices.length == 0)
        {
            return 0;
        }

        int max = 0;
        int min = Integer.MAX_VALUE;


        for (int i = 0; i < prices.length; i++)
        {
            max = Math.max(max, prices[i]-min);
            min = Math.min(prices[i], min);
        }

        return max;

    }

}

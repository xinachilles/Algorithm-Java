/**
 * Created by xhu on 12/19/16.
 */
public class BestTimeBuySellStockCooldown {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        int[] cooldown = new int[prices.length];

        buy[0] = -prices[0];
        sell[0] = Integer.MIN_VALUE;
        cooldown[0] = 0;

        for (int i = 1; i < prices.length; i++) {

            cooldown[i] = Math.max(sell[i-1], cooldown[i - 1]);

            buy[i] = Math.max(cooldown[i-1]-prices[i], buy[i - 1]);

            sell[i] = prices[i] + buy[i - 1];
        }

        return Math.max(sell[prices.length - 1], Math.max(buy[prices.length - 1], cooldown[prices.length - 1]));

    }
}

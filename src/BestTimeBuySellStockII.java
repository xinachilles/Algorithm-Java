/**
 * Created by xhu on 10/23/16.
 */
public class BestTimeBuySellStockII {
    public int maxProfit(int[] prices) {
        int max = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] < prices[j]) {
                    max = max + prices[j] - prices[i];
                    i = j;
                    break;
                }
            }
        }

        return max;
    }
}

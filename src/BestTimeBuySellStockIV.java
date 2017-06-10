/**
 * Created by xhu on 11/25/16.
 */
public class BestTimeBuySellStockIV {

    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int[][] local = new int[prices.length][k + 1];
        // local[i[[j]: the j transaction, i should be included
        int[][] gobal = new int[prices.length][k];
        // gobal[i][j] : the j transaction, i may or not be included


        for (int i = 1; i < prices.length; i++) {
            int gainorlose = prices[i] - prices[i - 1];
            for (int j = 1; j <= k; j++) {
                local[i][j] = Math.max(gobal[i - 1][j - 1], local[i-1][j]) + gainorlose;
                gobal[i][j] = Math.max(gobal[i-1][j], local[i][j]);
            }
        }

        return gobal[prices.length-1 ][k];


    }

    private int maxProfit1(int[] prices, int start, int end) {
        int max = 0;
        int min = prices[start];

        for (int i = start; i <= end; i++) {
            min = Math.min(prices[i], min);
            max = Math.max(max, prices[i] - min);
        }

        return max;
    }
}

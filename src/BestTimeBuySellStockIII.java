/**
 * Created by xhu on 10/30/16.
 */
public class BestTimeBuySellStockIII {
    public int maxProfit(int[] prices) {
       if(prices == null || prices.length == 0){
           return 0;
       }

        int[] left = new int[prices.length];
        left[0] = 0;
        int min = prices[0];
        int max = 0;

        for(int i = 1; i<prices.length;i++){
            min = Math.min(prices[i],min);
            max = Math.max(max, prices[i] - min);
            left[i] = max;
        }

        int[] right = new int[prices.length];
        right[right.length-1] = 0;
        int local = prices[prices.length-1];
        max  = 0;

        for(int i = prices.length-2; i>=0; i--){
            local = Math.max(prices[i],local);
            max = Math.max(max, local-prices[i]);
            right[i] = max;
        }

        max = Integer.MIN_VALUE;
        for(int i = 0; i<prices.length-1; i++){
            max = Math.max(left[i]+right[i+1],max);
        }

        return max;
    }

}

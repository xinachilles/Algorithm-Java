/**
 * Created by xhu on 12/19/16.
 */
public class BestTimeBuySellStockCooldown {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int[] hold = new int[prices.length];
        int[] sell = new int[prices.length];

        hold[0] = 0;
        sell[0] = -prices[0];

        for(int i = 1; i< prices.length; i++){
            if(i ==1) {
                // if the i = 1 day we hold the stock that is means we buy the stock at 0 day or 1 day
                hold[1] = Math.max(-prices[0], -prices[1]);
            }else{
                // if i day we hold the stock --- meaning i-1 day we have stock or we sell the stock on i-2 day
                // cooldown then by the stock on i day
                  hold[i] = Math.max(hold[i-1], sell[i-2] - prices[i]);
                }
            sell[i] = Math.max(sell[i-1], hold[i-1]+prices[i]);
            }

            return sell[prices.length-1];
        }
    }


import java.util.HashSet;
import java.util.Set;

public class MinimumCostTickets {
    public int mincostTickets(int[] days, int[] costs) {
        if(days == null || costs == null){
            return 0;
        }
        int[] dp = new int[days[days.length-1]+1];
        // dp[i] is menas the i day the min cost I need travel

        Set<Integer> travelDate = new HashSet<>();
        for(int day: days){
            travelDate.add(day);
        }

        dp[0] = 0;

        for(int i  =1; i<dp.length;i++) {
            if (!travelDate.contains(i)) {
                dp[i] = dp[i - 1];
            } else {

                int cost1 = dp[i - 1] + costs[0];
                int cost2 = dp[Math.max(0,i-7)] + costs[1];
                int cost3 = dp[Math.max(0,i - 30)] + costs[2];
                dp[i] = Math.min(Math.min(cost1, cost2), cost3);

            }
        }
        return dp[days.length-1];
    }
}

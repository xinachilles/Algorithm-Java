import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        if(days == null || costs == null || days.length == 0 || costs.length == 0){
            return  0;
        }
        int[] dp = new int[days[days.length-1]+1];
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i<days.length; i++){
            set.add(days[i]);
        }
        for(int i = 1; i<=days[days.length-1];i++){
            if(!set.contains(i)){
                dp[i] = dp[i-1];
            }else{
                int day1 = dp[i-1]+ costs[0];
                int day7 = i>=7? dp[i-7] + costs[1] :Integer.MAX_VALUE;
                int day30 = i>=30? dp[i-30]+ costs[2]: Integer.MAX_VALUE;

                dp[i] = Math.min(Math.min(day1,day7),day30);


            }
        }
        return dp[days[days.length-1]];
    }
}

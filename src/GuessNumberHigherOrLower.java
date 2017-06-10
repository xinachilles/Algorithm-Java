import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 12/10/16.
 */
public class GuessNumberHigherOrLower {
    public int getMoneyAmount(int n) {
        if (n <= 0) {
            return 0;
        }

        int[][] dp = new int[n + 1][n + 1];
        List<Integer> tracking = new ArrayList<>();
        return getMoneyAmountHelper(1, n, dp,tracking);


    }

    private int getMoneyAmountHelper(int left, int right, int[][] dp, List<Integer> tracking) {

        if (left >= right) return 0;

        if (dp[left][right] > 0) {
            return dp[left][right];
        }
     //   dp[left][right] = Integer.MAX_VALUE;

        for (int i = left; i <= right; i++) {
            int result = Math.min(dp[left][right], Math.max(getMoneyAmountHelper(left, i - 1, dp, tracking), getMoneyAmountHelper(i + 1, right, dp,tracking)) + i);
            if(dp[left][right] <result){
                tracking.add(i);
                dp[left][right] = result;
            }
        }
            return dp[left][right];
    }
}



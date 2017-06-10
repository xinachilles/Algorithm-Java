import java.util.ArrayList;

/**
 * Created by xhu on 11/24/16.
 */
public class MinimumSubarray {
    public int minSubArray(ArrayList<Integer> nums ) {
        // write your code
        int[] dp = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            dp[i] = nums.get(i);
        }

        int min = dp[0];
        for (int i = 1; i < nums.size(); i++) {
            if (dp[i - 1] < 0) {
                dp[i] = dp[i - 1] + nums.get(i);
            }

            min = Math.min(dp[i], min);
        }

        return min;

    }
}

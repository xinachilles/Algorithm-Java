/**
 * Created by xhu on 7/30/17.
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[][] dp = new int[nums.length + 1][k + 1];

        // dp[i,j] means end with ith, the number of subarray with sum of j
        dp[0][0] = 1;

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= k && j - nums[i - 1] >= 0; j++) {

                dp[i][j] += dp[i - 1][j - nums[i - 1]];
            }


        }

        return dp[nums.length][k];

    }

}

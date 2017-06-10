/**
 * Created by xhu on 12/17/16.
 */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int sum = 0;
        for (int n : nums) {
            sum = sum + n;
        }

        if (sum % 2 != 0) {
            return false;
        }

        sum = sum / 2;
        boolean[] dp = new boolean[sum + 1];
        //dp[i][j]  = true means from 0 to j th can find a subarray which sum is i

        dp[0] = true;

        for (int i = 0; i < dp.length; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[j + 1] = dp[j];
                if (j >= nums[i]) {
                    dp[j + 1] = dp[j + 1] || dp[j - nums[i]];
                }

            }
        }

        return dp[sum];


    }


}

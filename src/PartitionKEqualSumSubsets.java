import java.util.Arrays;

public class PartitionKEqualSumSubsets {
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
        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
        //dp[i][j]  = true means from 0 to j th can find a subarray which sum is i

        dp[0][0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i + 1][j] = dp[i][j];
                if (j >= nums[i] && dp[i][j - nums[i]]) {
                    dp[i + 1][j] = dp[i + 1][j] || true;

                }
            }
        }


        return dp[nums.length][sum];

    }
}

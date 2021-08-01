public class StoneGameII {

    public int stoneGameII(int[] piles) {
        // Write your code here
        if (piles == null || piles.length == 0) {
            return 0;
        }

        int[][] dp = new int[piles.length][piles.length];
        // suffixSum[i] starting from i sum up everything to the right: sum(piles[i, piles.length - 1])
        int[] suffixSum = new int[piles.length];
        suffixSum[piles.length - 1] = piles[piles.length - 1];
        // sum[i][j] means total number from i to j
        for (int i = piles.length - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }


        return stoneGameHelper(suffixSum, 0, piles.length - 1, dp);

    }

    private int stoneGameHelper(int[] suffixSum, int start, int m, int[][] dp) {
        if (start >= suffixSum.length) return 0;
// Number of remaining piles is <= than the number of piles we can take in the current turn 2*M. We just take all remaining piles.
        if (suffixSum.length - start <= 2 * m) return suffixSum[start];
        if (dp[start][m] > 0) {
            return dp[start][m];
        }
        int max = 0;
        for (int x = 1; x <= m; x++) {
            max = Math.max(suffixSum[start] - stoneGameHelper(suffixSum, start + x, Math.max(m, x), dp), max);
        }


        dp[start][m] = max;
        return max;
    }
}

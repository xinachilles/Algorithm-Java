import java.util.Arrays;

/**
 * Created by xhu on 2/12/17.
 */
public class StoneGame {
    public int stoneGame(int[] A) {
        // Write your code here
        if (A == null || A.length == 0) {
            return 0;
        }

        int[][] dp = new int[A.length][A.length];
        int[][] sum = new int[A.length][A.length];

        for (int i = 0; i < A.length; i++) {
            for (int j = i; j < A.length; j++) {
                if (i == j) {
                    sum[i][j] = A[i];
                } else {

                    sum[i][j] = sum[i][j - 1] + A[j];
                }
            }
        }


        stoneGameHelper(sum, 0, A.length - 1, dp);
        return dp[0][A.length - 1];
    }

    private int stoneGameHelper(int[][] sum, int start, int end, int[][] dp) {

        if (start == end) {
            dp[start][end] = sum[start][end];
            return dp[start][end];
        }

        if (dp[start][end] > 0) {
            return dp[start][end];
        }
        int min = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            int left = stoneGameHelper(sum, start, i, dp);
            int right = stoneGameHelper(sum, i + 1, end, dp);
            int current = sum[start][end];

            min = Math.min(left + right + current, min);
        }

        dp[start][end] = min;
        return min;
    }
}

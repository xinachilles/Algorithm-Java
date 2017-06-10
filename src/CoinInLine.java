/**
 * Created by xhu on 12/20/16.
 */
public class CoinInLine {
    public boolean firstWillWin(int[] values) {
        if (values == null || values.length == 0) {
            return false;
        }

        int[][] dp = new int[values.length][values.length];
        // dp[i][j] means the max value player can take if only i to j coin left


        for (int i = values.length - 1; i>=0; i--) {
            for (int j = values.length - 1; j >= i; j--) {
                if (j == i) {
                    dp[i][j] = values[i];
                }
                if (i + 1 == j) {
                    dp[i][j] = Math.max(values[j], values[j]);
                } else {
                    int takeleft = values[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]);
                    int takeright = values[j] + Math.min(dp[i][j - 2], dp[i + 1][j - 1]);

                    dp[i][j] = Math.max(takeleft, takeright);

                }
            }
        }
        int sum = 0;
        for (int i = 0; i < values.length; i++) {
            sum = sum + values[i];
        }

        return dp[0][values.length - 1] > sum - dp[0][values.length - 1];
    }
}

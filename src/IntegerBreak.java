/**
 * Created by xhu on 12/17/16.
 */
public class IntegerBreak {
    //integer break recusive
    int max = Integer.MIN_VALUE;

    public int integerBreak(int n) {
        if (n <= 1) {
            return n;
        }

        int[] dp = new int[n + 1];
        //dp[i] means the max max product can get if n = i

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 1; j < i; j++) {
                // first debug max = Math.Max(max, j * dp[i - j] );
                max = Math.max(max, j * Math.max(dp[i - j], (i - j)));
            }

            dp[i] = max;
        }


        return dp[n];
    }

}

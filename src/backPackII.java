/**
 * Created by xhu on 7/30/17.
 */
public class backPackII {
    public int backPackII(int m, int[] A, int V[]) {
        // write your code here
        if(A == null || V == null){
            return 0;
        }

        if(A.length != V.length){
            return 0;
        }

        int[][] dp = new int[A.length+1][m+1];

        // dp[i][j] means the maximum manes from 0 to i-1th backsize is j the

        for(int i = 0; i<A.length;i++){
            int count = Integer.MIN_VALUE;

            for(int j = 1; j<=m;j++){
                if(A[i] <=j && dp[i][j-A[i]] > Integer.MIN_VALUE && count< dp[i][j-A[i]]+V[i]){
                    count = dp[i][j-A[i]]+V[i];
                }

                dp[i+1][j] = count;
            }

        }

        return dp[A.length][m];

    }
}

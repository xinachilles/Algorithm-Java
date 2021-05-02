import java.util.HashMap;

public class LongestArithmeticSequence {
    public int longestArithSeqLength(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int res = 0;

        HashMap<Integer, Integer>[] dp = new HashMap[A.length];
        // dp[i] = map<i,j> menas the for 0 to i-1, the difference is i and the max length is j

        for (int i = 0; i < A.length; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int d = A[i] - A[j];
                if(!dp[j].containsKey(d)){
                    dp[j].put(d,1);
                }
                dp[i].put(d, dp[j].get(d)+ 1);
                res = Math.max(res, dp[j].get(d));
            }
        }

        return res;
    }
}

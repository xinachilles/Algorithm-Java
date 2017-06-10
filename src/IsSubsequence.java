/**
 * Created by xhu on 12/14/16.
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s == null) {
            return true;
        }

        if (t == null) {
            return false;
        }

        boolean[] dp = new boolean[s.length()];


        for (int i = 0; i < t.length(); i++) {
            for (int j = s.length() - 1; j >= 0; j--) {
                if (s.charAt(j) == t.charAt(i)) {
                    if (j == 0) {
                        dp[j] = true;
                    } else {
                        dp[j] = dp[j] || dp[j - 1];
                    }
                }
            }
        }


        return dp[s.length() - 1];
    }


}

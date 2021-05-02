/**
 * Created by xhu on 2/19/17.
 */
public class RegularExpressionMatching {

   /* public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        return isMatchHelper(s, p);

    }

    private boolean isMatchHelper(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }

        if (p.length() == 1) {
            if (s.length() == 1 && p.charAt(0) == '.' || p.charAt(0) == s.charAt(0)) {
                return true;
            }
        }

        if (p.length() > 1) {
            if (p.charAt(1) != '*') {
                if (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
                    return isMatch(s.substring(1), p.substring(1));
                }
            } else {
                if (p.charAt(0) == '.') {
                    return true;
                }

                // * will match zero
                // will match one or more than one preceding element
                if (p.charAt(0) == s.charAt(0)) {
                    for (int i = 1; i < s.length(); i++) {
                        if (isMatchHelper(s.substring(1), p.substring(2))) {
                            return true;
                        }
                    }
                }

                if (isMatchHelper(s, p.substring(2))) {
                    return true;
                }


            }
        }

        return false;
    }*/

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        boolean[][] dp = new boolean[s.length()][p.length()];

        // for inital, if s is empty and j is empty the dp[0][0] is true
        dp[0][0] = true;
        // if j is empty then dp[i][0] is always false
        // if i is empty then dp[0][j] is = dp[0][j-2] means j take 0 occurance
        // for example s = "" and p ="a*b*"
        // when we see *, we look at 2 poistion before
        for (int j = 0; j < p.length(); j++) {
            if (p.charAt(j) == '*') {
                dp[0][j + 1] = (j >= 1 && dp[0][j - 1]);
            }
        }


        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                // if p[i] is not start and if p[i] == s[i], we will look at the diagonal value
                if (p.charAt(j) != '*' && s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                }

                if (p.charAt(j) == '*') {
                    // if p[i] is *, we can gook at the 2 poistion, 2 entry before
                    // or if p[i-1] equal to s[i], we just need look at it's up entry

                    dp[i + 1][j + 1] = (j>=1 && dp[i][j - 1]) // 0 occurance
                            || (j>=1&& (s.charAt(i) == p.charAt(j-1) || p.charAt(j-1) == '.') && dp[i][j + 1]);
                }
            }
        }

        return dp[s.length()][p.length()];


    }

}

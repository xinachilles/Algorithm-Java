import java.util.HashMap;
import java.util.Map;


/**
 * Created by xhu on 1/5/17.
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        boolean[][] dp = new boolean[s.length()][s.length()];
        // dp[i,j] mean the  palidromic string from substring index i to index j is palidromic or not
        int max = 1;
        String result = String.valueOf(s.charAt(0));

        for (int start = s.length() - 1; start >= 0; start--) {
            for (int end = start; end < s.length(); end++) {
                if (s.charAt(start) == s.charAt(end)){
                    {
                        if (end - start + 1 <= 3 || end - start + 1 > 3 && dp[start + 1][end - 1]) {
                            dp[start][end] = true;
                        }
                    }

                    if (dp[start][end]) {
                       if(end-start+1>max){
                           max = end-start+1;
                           result = s.substring(start,end+1);
                       }
                    }
                }
            }
        }

        return result;
    }
}


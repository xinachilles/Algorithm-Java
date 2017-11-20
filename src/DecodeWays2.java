/**
 * Created by xhu on 7/15/17.
 */
public class DecodeWays2 {


   /* public int decode(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] dp = new int[s.length() + 1];
        // dp[i] means the number of decoding way from (s(0) to s[i])
        dp[0] = 1;

        if (s.charAt(0) == '*') {
            int number = 0;
            for (char i = '0'; i <= '9'; i++) {

                number += decode(i + s.substring(1));


            }

            return number;
        } else if (s.charAt(0) != '0') {

            dp[1] = 1;

            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == '*') {
                    int number = 0;
                    number = dp[i - 1];

                    for (char j = '0'; j <= '9'; j++) {
                        StringBuilder temp = new StringBuilder();
                        temp.append(s.charAt(i - 1)).append(j).append(s.substring(i + 1));
                        number += decode(temp.toString());
                    }

                    return number - 1;
                } else {
                    if (s.charAt(i) != '0') {
                        dp[i + 1] = dp[i];
                    }

                    if (i >= 1) {

                        int number = Integer.valueOf(s.substring(i - 1, i + 1));
                        if (number >= 10 && number <= 26) {
                            dp[i + 1] += dp[i - 1];
                        }

                    }
                }

            }
        }


        return dp[s.length()];


    }*/

    public long decodeWays(String s) {

        int n = s.length();
        // f2 is the answer to sub string ending at position i; Initially i = 0.
        long f1 = 1, f2 = helper(s.substring(0, 1));
        // DP to get f2 for sub string ending at position n-1;
        for (int i = 1; i < n; i++) {
            long f3 = (f2 * helper(s.substring(i, i + 1))) + (f1 * helper(s.substring(i - 1, i + 1)));
            f1 = f2;
            f2 = f3;
        }
        return  f2;
    }

    private int helper(String s) {
        if (s.length() == 1) {
            if (s.charAt(0) == '*') return 9;
            return s.charAt(0) == '0' ? 0 : 1;
        }
        // 11-26, except 20 because '*' is 1-9
        if (s.equals("**"))
            return 15;
        else if (s.charAt(1) == '*') {
            if (s.charAt(0) == '1') return 9;
            return s.charAt(0) == '2' ? 6 : 0;
        } else if (s.charAt(0) == '*')
            return s.charAt(1) <= '6' ? 2 : 1;
        else {
            // if two digits, it has to be in [10 26]; no leading 0
            int number = (s.charAt(0) - '0') * 10 + (s.charAt(1) - '0');
            return number >= 10 && number <= 26 ? 1 : 0;
        }
    }
}



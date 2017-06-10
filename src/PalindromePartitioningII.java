/**
 * Created by xhu on 1/21/17.
 */
public class PalindromePartitioningII {
    //
   /* public int minCut(String s) {
        if (s == null || s.length() == 0)
        {
            return 0;
        }

        int[] dp = new int[s.length()];
        int[][] isPalindrome = new int[s.length()][s.length()];


        //dp [i] means the min cut for a palindrome partition of 0 .. i
        dp[0] = 0;
        for (int i = 1; i < s.length(); i++)
        {

            if (isPalindrome(s,0,i,isPalindrome ))
            {
                dp[i] = 0;
            }
            else
            {
                dp[i] = dp[i-1]+1;
                for (int j = 0; j < i; j++)
                {
                    if (isPalindrome(s,j+1,i,isPalindrome))
                    {
                        dp[i] = Math.min(dp[i], dp[j]+1);
                    }
                }


            }
        }

        return dp[s.length()-1];
    }*/

    /*private boolean[][] getPalindrome(String s, boolean[][] isPalindrome) {

        for (int i = 0; i < s.length(); i++) {
            for (int l = 1; l < s.length(); l++) {
                if (i + l < s.length() && i - l >= 0 && s.charAt(i + l) == s.charAt(i - l)) {
                    isPalindrome[i - l][i + l] = true;
                }
            }
        }


    }*/
}

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 11/5/16.
 */
public class PalindromePartitioning {
    // palindrome partitiioning
/*
    public List<List<String>> partiton(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null) {
            return result;
        }

        List<String> solution = new ArrayList<>();
        partitonHelper(s, 0, result, solution);
        return result;
    }

    private void partitonHelper(String s, int index, List<List<String>> result, List<String> solution) {
        if (index == s.length()) {
            result.add(new ArrayList<>(solution));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            // java
            //String substring = s.Substring(index, i + 1);

            String substring = s.substring(index, i - index + 1);
            if (isPalindrom(substring)) {
                solution.add(substring);
                partitonHelper(s, i + 1, result, solution);
                solution.remove(solution.size() - 1);

            }
        }
    }

    private boolean isPalindrom(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }*/

    //palindrome partitioning
    public int minCut(String s)
    {
        if (s == null || s.length() == 0)
        {
            return 0;
        }

        int[] dp = new int[s.length()];
        //dp [i] means the min cut for a palindrome partition of 0 .. i
        dp[0] = 0;
        for (int i = 0; i < s.length(); i++)
        {
            s.substring(0, i + 1);
            if (isPalindrome(s))
            {
                dp[i] = 1;
            }
            else
            {
                dp[i] = dp[i - 1] + 1;
                for (int j = 0; j < i; j++)
                {
                    if (isPalindrome(s.substring(j + 1, i)))
                    {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }


            }
        }

        return dp[s.length() - 1];
    }

    private boolean isPalindrome(String s)
    {
        int start = 0;
        int end = s.length() - 1;

        while (start < end)
        {
            if (s.charAt(start) != s.charAt(end))
            {
                return false;
            }
        }

        return true;
    }

}

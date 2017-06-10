/**
 * Created by xhu on 9/30/16.
 */
public class LongestPalindromicSubstring {

    int max = 1;
    String result = "";

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        result = s.substring(0, 1);

        for (int i = 0; i < s.length() - 1; i++) {
            LongestPalindromicSubstringHelper(i, i + 1, s);
            LongestPalindromicSubstringHelper(i, i, s);
        }

        return result;
    }

    private void LongestPalindromicSubstringHelper(int start, int end, String s) {
        int lo = start;
        int hi = end;

        while (lo >= 0 && hi <= s.length() - 1 && s.charAt(lo) == s.charAt(hi)) {

            if (hi- lo + 1 > max) {
                result = s.substring(lo, hi+1);
            }
                lo--;
                hi++;


        }
    }
}

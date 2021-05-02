package MOA;

public class LongestSubstringWithout3Contiguous {

    public static String validLongestSubstring(String s) {
        if (s.length() < 3)
            return s;
        int cur = 0, end = 1;
        char c = s.charAt(0);
        int count = 1;
        int maxLen = 1;
        int start = 0;
        while (end < s.length()) {
            if (s.charAt(end) == c) {
                count ++;
                if (count == 2) {
                    if (end - cur + 1 > maxLen) {
                        maxLen = end - cur + 1;
                        start = cur;
                    }
                }
                else {
                    cur = end - 1;
                }
            }
            else {
                c = s.charAt(end);
                count = 1;
                if (end - cur + 1 > maxLen) {
                    maxLen = end - cur + 1;
                    start = cur;
                }
            }
            end ++;
        }
        return s.substring(start, start + maxLen);
    }



}

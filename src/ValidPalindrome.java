/**
 * Created by xhu on 11/26/16.
 */
public class ValidPalindrome {
    //valid palindrome
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            int left = Character.toLowerCase(s.charAt(start));
            int right = Character.toLowerCase(s.charAt(end));

            if (left > 'z' || left < 'a'|| !Character.isDigit(left)) {
                start++;
                continue;
            }

            if (right > 'z' || right < 'a'||!Character.isDigit(right) ) {
                end--;
                continue;
            }

            if (left != right) {
                return false;
            }

            start++;
            end--;
        }

        return true;

    }
}

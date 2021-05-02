public class ValidPalindromeII {

    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {

                return  isPalindromic(s, l+1, r )  // adcbca , i = 1 r = 4, delete i
                        || isPalindromic(s, l, r-1); // acbbeca, i = 2 r= 5 delete r
            }

            l++;
            r--;
        }

        return true;
    }

    public boolean isPalindromic(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}

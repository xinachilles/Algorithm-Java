package MOA;

public class MaxSemiAlternatingString {
    public int  maxSemiAlternatingString(String s) {
        char[] arr = s.toCharArray();
        if (arr.length < 3) {
            return 0;
        }
       // String res = "";
        int len = arr.length, a = 0, b = 0, l = 0, r = 0, max = 0;
        while (r < len) {
            char c = arr[r];
            if (c == 'a') {
                b = 0;
                a++;
            } else if (c == 'b') {
                a = 0;
                b++;
            }
            if (a < 3 && b < 3) {
                if (r - l + 1 > max) {
                    max = r - l + 1;
                  //  res = s.substring(l, r + 1);
                }
            } else {
                l = r - 1;
                if (a == 3) {
                    a = 2;
                } else if (b == 3) {
                    b = 2;
                }
            }
            r++;
        }
        return max;
    }
}

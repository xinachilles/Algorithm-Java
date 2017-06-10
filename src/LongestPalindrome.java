import java.util.HashMap;
import java.util.Map;


/**
 * Created by xhu on 1/5/17.
 */
public class LongestPalindrome {

    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> counts = new HashMap<>();

        for (Character c : s.toCharArray()) {
            if (counts.containsKey(c)) {
                counts.put(c, counts.get(c) + 1);
            } else {
                counts.put(c, 1);
            }
        }
        int length = 0;
        int odd = 0;
        for (Character key : counts.keySet()) {


            if (counts.get(key) % 2 == 0) {
                length += counts.get(key);
            } else {
                length += counts.get(key) - 1;
                odd++;
            }

        }

        return odd > 0 ? length + 1 : length;
    }
}

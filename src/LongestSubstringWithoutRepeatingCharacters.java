import java.util.HashSet;

/**
 * Created by xhu on 1/16/17.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        HashSet<Character> maps = new HashSet<>();
        int max = 1;

        int left = 0;
        int right = 0;

        for (; right < s.length(); right++) {
            char current = s.charAt(right);
            if (!maps.contains(current)) {
                maps.add(current);
                if (max < right - left + 1) {
                    max = right - left + 1;
                }
            } else {
                while (maps.contains(current)) {
                    maps.remove(s.charAt(left));
                    left++;
                }

            }

        }

        return max;

    }
}

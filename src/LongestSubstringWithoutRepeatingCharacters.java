import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by xhu on 1/16/17.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> maps = new HashMap<>();
        int max = 1;

        int left = 0;
        int right = 0;

        for (; right < s.length(); right++) {
            char current = s.charAt(right);
            maps.put(current, maps.getOrDefault(current, 0) + 1);
            if (maps.get(current) == 1) {
                if (max < right - left + 1) {
                    max = right - left + 1;
                }
            } else {
                while (maps.get(current) > 1) {
                    maps.put(current, maps.get(current) - 1);
                    left++;
                }

            }

        }

        return max;

    }
}

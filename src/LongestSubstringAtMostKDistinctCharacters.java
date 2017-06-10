import java.util.HashMap;
import java.util.Map;

/**
 * Created by xhu on 11/26/16.
 */
public class LongestSubstringAtMostKDistinctCharacters {
    //longest substring with a most k distinct
    public int lengthOflongestsubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int left = 0;
        int right = 0;
        Map<Character, Integer> mapping = new HashMap<Character, Integer>();
        int longest = Integer.MIN_VALUE;

        for (; right < s.length(); right++) {
            char current = s.charAt(right);
            if (!mapping.containsKey(current)) {

                mapping.put(current, 1);
            } else {
                mapping.put(current, mapping.get(current) + 1);
            }


            if (mapping.size() <= k) {
                longest = Math.max(longest, Math.abs(right - left + 1));
            } else {
                while (mapping.size() > k) {
                    char l = s.charAt(left);
                    mapping.put(l, mapping.get(l) - 1);
                    if (mapping.get(l) == 0) {
                        mapping.remove(l);
                    }

                    left++;
                }
            }

        }

        return longest;

    }
}

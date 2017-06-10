package AmazonOA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xhu on 4/15/17.
 */
public class FindAllAnagramsString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        Map<Character, Integer> maps = new HashMap<>();
        for (Character c : p.toCharArray()) {
            if (maps.containsKey(c)) {
                maps.put(c, maps.get(c) + 1);
            } else {
                maps.put(c, 1);
            }
        }

        int right = 0;
        int left = 0;
        int count = maps.size();

        for (; right < s.length(); right++) {
            Character current = s.charAt(right);
            if (maps.containsKey(current)) {

                maps.put(current, maps.get(current) - 1);
                if (maps.get(current) == 0) {
                    count--;
                }
            }

            while (count == 0) {
                if (right - left + 1 == p.length()) {
                    result.add(left);
                }

                Character temp = s.charAt(left);
                if (maps.containsKey(temp)) {


                    maps.put(temp, maps.get(temp) + 1);
                    if (maps.get(temp) > 0) {
                        count++;
                    }
                }
                left++;
            }
        }

        return result;

    }
}

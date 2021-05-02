import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInString {
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || p == null) {
            return null;
        }

        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> maps = new HashMap<>();

        for (Character a : p.toCharArray()) {
            maps.put(a, maps.getOrDefault(a, 0) + 1);
        }

        int left = 0;
        int size = maps.keySet().size();
        for (int right = 0; right < p.length(); right++) {
            Character c = p.charAt(right);
            if (maps.containsKey(c)) {
                maps.put(c, maps.get(c) - 1);
                if (maps.get(c) == 0) {
                    size--;
                }

            }

            while (size == 0) {
                if (right - left + 1 == s.length()) {
                    result.add(left);
                }

                Character l = p.charAt(left);
                if (maps.containsKey(l)) {
                    maps.put(l, maps.get(l) + 1);

                    if (maps.get(l) > 0) {
                        size++;
                    }
                }

                left++;
            }
        }

        return result;
    }
}

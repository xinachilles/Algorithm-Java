import java.util.*;

/**
 * Created by xhu on 4/12/17.
 */
public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        Map<Character, Integer> counts = new TreeMap<>();
        int max = 0;
        for (Character c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 1) + 1);
            max = Math.max(max, counts.get(c));
        }

        // List<Character>[] sort = new List[max];
        // sort the Map by value, descend order
        StringBuilder result = new StringBuilder();
        for (Character key : counts.keySet()) {
            result.append(counts.get(key));
        }

        return result.toString();


    }
}

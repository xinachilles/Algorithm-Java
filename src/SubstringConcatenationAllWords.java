import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xhu on 9/12/16.
 */
public class SubstringConcatenationAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        // we use two hashmaps one is for s and one is for words.
        // the hashmaps stored the pair of string the count of the string

        Map<String, Integer> wordsMap = new HashMap<>();
        for (String w : words) {
            if (!wordsMap.containsKey(w)) {
                wordsMap.put(w, 1);
            } else {
                wordsMap.put(w, wordsMap.get(w) + 1);
            }
        }

        int numberOfWords = words.length;
        int length = words[0].length();
        int total = numberOfWords * length;
        // go through the s and i is the start point of the substring
        for (int i = 0; i + total < s.length(); i++) {
            // another hashmap use to compare with  wordsMap
            Map<String, Integer> sMaps = new HashMap<String, Integer>();
            int j = 0;
            for (; j < numberOfWords; j++) {
                String substring = s.substring((i + j * length), (i + j * length) + length);
                if (!sMaps.containsKey(substring)) {
                    sMaps.put(substring, 1);
                } else {
                    sMaps.put(substring, sMaps.get(substring) + 1);
                }
                //compare the sMaps with the wordsMap
                if (!wordsMap.containsKey(substring) || sMaps.get(substring) > wordsMap.get(substring)) {
                    break;
                }
            }

            if (j == numberOfWords) {
                result.add(i);
            }
        }

        return result;
    }
}

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by xhu on 11/5/16.
 */
public class WordPatternII {
    //word pattern ii


    public boolean wordPatternMatch(String pattern, String str) {
        if (pattern == null || str == null) {
            return false;
        }

        Map<Character, String> patToStr = new HashMap<>();
        Map<String, Character> strToPat = new HashMap<>();

        Set<String> sets = new HashSet<>();
        return wordPatternMatchHelper(pattern, str, patToStr, strToPat);
    }

    private boolean wordPatternMatchHelper(String pattern, String str, Map<Character, String> patToStr, Map<String, Character> strToPat) {
        if (pattern.length() == 0) {
            return str.length() == 0;
        }
        char pat = pattern.charAt(0);
        for (int i = 0; i < str.length(); i++) {

            String word = str.substring(0, i + 1);


            if (!patToStr.containsKey(pat) && !strToPat.containsKey(word)) {
                patToStr.put(pat, word);
                strToPat.put(word, pat);

                if (wordPatternMatchHelper(pattern.substring(1), str.substring(i + 1), patToStr, strToPat)) {
                    return true;
                }

                patToStr.remove(pat);
                strToPat.remove(word);
            } else {
                if (patToStr.containsKey(pat) && strToPat.containsKey(word) && (!patToStr.get(pat).equals(word)) && (!strToPat.get(str).equals(word))) {
                    if (wordPatternMatchHelper(pattern.substring(1), str.substring(i + 1), patToStr, strToPat)) {
                        return true;
                    }
                }
            }
        }
        return false;

    }

    private boolean isValid(char pat, String str, Map<Character, String> patToStr, Map<String, Character> strToPat) {
        if (!patToStr.containsKey(pat) && !strToPat.containsKey(str)) {
            patToStr.put(pat, str);
            strToPat.put(str, pat);
        } else {

        }

        return true;
    }
}

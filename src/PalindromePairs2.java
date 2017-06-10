import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xhu on 9/26/16.
 */
public class PalindromePairs2 {

    public List<List<Integer>> palindromePairs(String[] words) {
        if (words == null || words.length == 0) {
            return null;
        }
        Map<String, Integer> maps = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++) {
            maps.put(words[i], i);
        }

        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        for (int i = 0; i < words.length; i++) {
            List<Integer> result = new ArrayList<Integer>();
            for (int j = 0; j <words[i].length(); j++) {
                StringBuilder str1 = new StringBuilder(words[i].substring(0, j));
                StringBuilder str2 = new StringBuilder(words[i].substring(j, words[i].length()));
                StringBuilder revStr2 = str2.reverse();
                StringBuilder revStr1 = str1.reverse();

                if (isPalidrom(str1.toString()) && maps.containsKey(revStr2.toString()) && i != maps.get(revStr2.toString())) {
                    result.add(i);
                    result.add(maps.get(revStr2.toString()));
                }

                if (isPalidrom(str2.toString()) && maps.containsKey(revStr1.toString()) && i != maps.get(revStr1.toString()) && str1.length() > 0) {
                    result.add(i);
                    result.add(maps.get(revStr1.toString()));
                }
            }

            ans.add(result);
        }
        return ans;
    }

    private boolean isPalidrom(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;

    }
}

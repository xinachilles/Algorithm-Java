import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by xhu on 11/5/16.
 */
public class WordBreakii {
    // word break ii
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }

        wordBreakHelper(s, wordDict, 0, "", result);
        return result;
    }

    private void wordBreakHelper(String s, Set<String> wordDict, int index, String solution, List<String> result) {
        if (index > s.length()) {
            return;
        }

        if (index == s.length()) {
            result.add(solution);
            return;
        }

        for (int i = index; i < s.length(); i++) {
            // java version
            String substring = s.substring(index, i + 1);
            if (wordDict.contains(substring)) {
                wordDict.remove(substring);
                wordBreakHelper(s, wordDict, i + 1, solution.length() == 0 ? substring : solution + " " + substring, result);
                wordDict.add(substring);
            }

        }
    }
}

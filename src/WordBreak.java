import java.util.*;

/**
 * Created by xhu on 11/10/16.
 */
public class WordBreak {
    // word break

    // word break I

    public boolean wordBreak(String s, HashSet<String> wordDict) {
        if (s == null || s.length() == 0) {
            return false;
        }

        boolean[] canbeBreak = new boolean[s.length()];
        //canbeBreak[i] means s[i] can be break..

        for (int i = 0; i < s.length(); i++) {
            String substring = s.substring(0, i);
            if (wordDict.contains(substring)) {
                canbeBreak[i] = true;
            } else {
                for (int j = 0; j < i; j++) {
                    if (canbeBreak[j] && wordDict.contains(s.substring(j, i + 1))) {
                        canbeBreak[i] = true;
                        continue;
                    }
                }
            }


        }

        return canbeBreak[s.length() - 1];
    }

}





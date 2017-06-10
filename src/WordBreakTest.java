import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by xhu on 11/26/16.
 */
public class WordBreakTest {
    @Test
    public void wordBreak() throws Exception {
        WordBreak target = new WordBreak();
        HashSet<String> dict = new HashSet<>();
        dict.add("leet");
        dict.add("code");
        target.wordBreak("leetcode", dict);
    }

}
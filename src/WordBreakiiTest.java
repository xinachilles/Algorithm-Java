import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;

public class WordBreakiiTest {

    @Test
    public void wordBreak() {
       // "catsanddog"
       //         ["cat","cats","and","sand","dog"]
        HashSet<String> dict = new HashSet<>();
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");

        WordBreakii test = new WordBreakii();
        test.wordBreak("catsanddog",dict);
    }
}
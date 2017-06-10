import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 11/17/16.
 */
public class wordDictionaryTest {
    @Test
    public void addWord() throws Exception {
        wordDictionary target = new wordDictionary();

        target.addWord("a");
        target.addWord("a");
        target.search(".");
        target.search("a");
        target.search("aa");
        target.search("a");
        target.search(".a");
        target.search("a.");
    }

}
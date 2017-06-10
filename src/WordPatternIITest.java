import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 11/5/16.
 */
public class WordPatternIITest {
    @Test
    //"abab"
//"redblueredblue"
    public void wordPatternMatch() throws Exception {
            WordPatternII target = new WordPatternII();
            target.wordPatternMatch("abab","redblueredblue");
    }

}
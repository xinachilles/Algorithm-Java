import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 9/26/16.
 */
public class PalindromePairs3Test {

    @Test
    public void testPalindromePairs() throws Exception {
            PalindromePairs3 test = new PalindromePairs3();
            String[] words = {"abcd","dcba","lls","s","sssll"};
            test.palindromePairs(words);
    }
}
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 9/26/16.
 */
public class PalindromePairs2Test {

    @Test
    public void testPalindromePairs() throws Exception {
        PalindromePairs2 test = new PalindromePairs2();
        String[] words= {"abcd","dcba","lls","s","sssll"};
        test.palindromePairs(words);
    }


}
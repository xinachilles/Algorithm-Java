import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 2/12/17.
 */
public class ScrambleStringTest {
    @Test
    public void isScramble() throws Exception {
        ScrambleString target = new ScrambleString();
        target.isScramble("a","a");
    }

}
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 5/27/17.
 */
public class PermutationStringTest {
    @Test
    public void checkInclusion() throws Exception {
        PermutationString target = new PermutationString();
        target.checkInclusion("abc","bbbca");
    }

}
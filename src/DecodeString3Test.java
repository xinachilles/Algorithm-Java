import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 6/23/17.
 */
public class DecodeString3Test {
    @Test
    public void decode() throws Exception {
        DecodeString3 target = new DecodeString3();
        String test = target.Encode("aaaabbbbcccd");

        String test2 = target.Decode(test);
    }

}
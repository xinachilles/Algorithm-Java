package FBOA;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 7/8/17.
 */
public class LowercaseUpcaseTest {
    @Test
    public void allLowerAndUpcase() throws Exception {
        LowercaseUpcase target = new LowercaseUpcase();
        target.AllLowerAndUpcase("ab");
    }

}
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 10/22/16.
 */
public class FullJustifyTest {
    @Test
    public void fullJustify() throws Exception {
        FullJustify target  = new FullJustify();
        target.fullJustify(new String[]{"a","b","c","d","e"},3);

    }

}
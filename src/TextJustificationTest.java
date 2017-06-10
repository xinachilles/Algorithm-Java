import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 10/15/16.
 */
public class TextJustificationTest {
    @Test
    public void fullJustify() throws Exception {
            TextJustification target = new TextJustification();
            target.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."},16);
    }

}
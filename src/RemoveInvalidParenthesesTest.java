import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 2/4/17.
 */
public class RemoveInvalidParenthesesTest {
    @Test
    public void removeInvalidParentheses() throws Exception {
        RemoveInvalidParentheses target = new RemoveInvalidParentheses();
        target.removeInvalidParentheses(")(f");
    }

}
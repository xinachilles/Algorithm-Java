import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 5/18/17.
 */
public class SimplifyPathTest {
    @Test
    public void simplifyPath() throws Exception {
        SimplifyPath target = new SimplifyPath();
        target.simplifyPath("/...");
    }

}
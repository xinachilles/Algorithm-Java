import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 12/12/16.
 */
public class FlipGameIITest {
    @Test
    public void canWin() throws Exception {
            FlipGameII target = new FlipGameII();
            target.canWin("++++");
    }

}
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 3/5/17.
 */
public class BullsCowsTest {
    @Test
    public void getHit() throws Exception {
        BullsCows target = new BullsCows();
        target.getHit("1807","7810");
    }

}
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 12/15/16.
 */
public class RussianDollEnvelopesTest {
    @Test
    public void maxEnvelope() throws Exception {
            RussianDollEnvelopes target = new RussianDollEnvelopes();
            target.maxEnvelope(new int[][] {new int[]{5,4},new int[]{6,4}, new int[] {6,7},new int[]{2,3}} );
    }

}
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 4/13/17.
 */
public class SlidingWindowMedianTest {
    @Test
    public void medianSlidingWindow() throws Exception {
        SlidingWindowMedian target = new SlidingWindowMedian();
        target.medianSlidingWindow(new int[]{1,4,2,3},4);
    }

}
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 1/27/17.
 */
public class SummaryRanges2Test {
    @Test
    public void addNum() throws Exception {
        SummaryRanges2 target = new SummaryRanges2();
        target.addNum(1);
        target.addNum(3);
        target.addNum(2);

        target.getIntervals();
    }

}
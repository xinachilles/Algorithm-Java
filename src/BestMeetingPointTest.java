import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 2/18/17.
 */
public class BestMeetingPointTest {
    @Test
    public void minTotalDistance() throws Exception {
        BestMeetingPoint target=  new BestMeetingPoint();
        target.minTotalDistance(new int[][]{
               new int[]{1,0,0,0,1},new int[]{0,0,0,0,0}, new int[] {0,0,1,0,0}});

    }

}
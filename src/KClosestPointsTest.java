import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 7/29/17.
 */
public class KClosestPointsTest {
    @Test
    public void kClosest() throws Exception {
        //[[4,6],[4,7],[4,4],[2,5],[1,1]], [0,0], 3
        KClosestPoints target = new KClosestPoints();
        target.kClosest(new Point[] {new Point(4,6), new Point(4,7),new Point(4,4), new Point(2,5),
                                     new Point(1,1) }, new Point(0,0),3 );
    }

}
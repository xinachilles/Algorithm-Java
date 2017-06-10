import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 3/11/17.
 */
public class RectangleOverlapTest {
    @Test
    public void doOverlap() throws Exception {
            RectangleOverlap target = new RectangleOverlap();
            target.doOverlap(new Point(0,8),new Point(8,0), new Point(6,6),new Point(10,0));
    }

}
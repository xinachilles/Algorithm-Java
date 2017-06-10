import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 4/23/17.
 */
public class HitCounterTest {
    @Test
    public void hit() throws Exception {
        HitCounter target = new HitCounter();
        target.hit(1);
        target.hit(2);
        target.hit(3);
        target.getHits(4);

        target.hit(300);
        target.getHits(300);
        target.getHits(301);

    }

}
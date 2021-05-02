import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumAreaRectangleIITest {

    @Test
    public void minAreaFreeRect() {
        MinimumAreaRectangleII  test = new MinimumAreaRectangleII();
        test.minAreaFreeRect(new int[][] { new int[]{1,2},new int[]{2,1},new int[]{1,0},new int[]{0,1}});
    }
}
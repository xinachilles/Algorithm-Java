import org.junit.Test;

import static org.junit.Assert.*;

public class PathMaximumGoldTest {

    @Test
    public void getMaximumGold() {
        PathMaximumGold test = new PathMaximumGold();
        test.getMaximumGold(new int[][] {new int[]{0,6,0},
                                         new int[]{5,8,7},
                                         new int[]{0,9,0}});
    }
}
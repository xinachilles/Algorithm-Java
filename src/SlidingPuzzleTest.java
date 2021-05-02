import org.junit.Test;

import static org.junit.Assert.*;

public class SlidingPuzzleTest {

    @Test
    public void slidingPuzzle() {
        SlidingPuzzle test = new SlidingPuzzle();
        test.slidingPuzzle(new int[][]{{1,2,3},{5,4,0}});
    }
}
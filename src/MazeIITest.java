import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 5/29/17.
 */
public class MazeIITest {
    @Test
    public void shortestDistance() throws Exception {
        MazeII target=  new MazeII();
        target.shortestDistance(new int[][]{ new int[]{0,0,1,0,0},new int[]{0,0,0,0,0},new int[]{0,0,0,1,0},
                new int[]{1,1,0,1,1}, new int[]{0,0,0,0,0}},new int[]{0,4},new int[]{4,4} );
    }

}
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 12/29/16.
 */
public class ShortestDistanceAllBuildingsTest {
    @Test
    public void shortestDistance() throws Exception {
        ShortestDistanceAllBuildings target = new ShortestDistanceAllBuildings();
        target.shortestDistance(new int[][] {new int[]{1,0,2,0,1},new int[] {0,0,0,0,0},new int[] {0,0,1,0,0}});
    }

}
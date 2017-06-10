import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 12/28/16.
 */
public class NumberIslandsTest {
    @Test
    public void numIslands() throws Exception {
        NumberIslands target  = new NumberIslands();
        target.numIslands(new char[][]{"111".toCharArray(),"010".toCharArray(),"111".toCharArray()});
    }

}
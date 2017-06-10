import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 2/20/17.
 */
public class NumberIslandsIITest {
    @Test
    public void numIslands2() throws Exception {
        NumberIslandsII target = new NumberIslandsII();
        int[][] position  = new int[][]{new int[]{0,1},
                                        new int[] {1,2},
                                        new int[] {2,1},
                                        new int[] {1,0},
                                        new int [] {0,2},
                                        new int[]   {0,0},
                                        new int[]    {1,1}};
        target.numIslands2(3,3,position);
    }

}
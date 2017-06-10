import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 12/23/16.
 */
public class MaxSumRectangleNoLargerThanKTest {
    @Test
    public void maxSumSubmatrix() throws Exception {
        MaxSumRectangleNoLargerThanK target = new MaxSumRectangleNoLargerThanK();
        target.maxSumSubmatrix(new int[][]{new int[]{5,-4,-3,4},new int[]{-3,-4,4,5},new int[] {5,1,5,-4}},10);

      //  target.maxSumSubmatrix(new int[][]{new int[]{1,0,1},new int[]{0,-2,3},},2);
    }

}
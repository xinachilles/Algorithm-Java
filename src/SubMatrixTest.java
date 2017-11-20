import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 6/17/17.
 */
public class SubMatrixTest {
    @Test
    public void maxSum() throws Exception {
        int input[][] = {{ 2,  1, -3, -4,  5},
                { 0,  6,  3,  4,  1},
                { 2, -2, -1,  4, -5},
                {-3,  3,  1,  0,  3}};

        SubMatrix target = new SubMatrix();
        SubMatrix.Result r = target.maxSum(input);
    }

}
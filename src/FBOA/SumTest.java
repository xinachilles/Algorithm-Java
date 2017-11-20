package FBOA;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 7/9/17.
 */
public class SumTest {
    @Test
    public void combinationSum() throws Exception {
        Sum target = new Sum();
        target.CombinationSum(new int[]{1,2,3},5);
    }

}
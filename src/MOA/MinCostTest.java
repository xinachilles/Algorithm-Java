package MOA;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinCostTest {

    @Test
    public void getMinCost() {
        MinCost test = new MinCost();
        test.getMinCost("aabbcc", new int[]{1,2,1,2,1,2});
    }
}
package MOA;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumberFractionsSumUp1Test {

    @Test
    public void solve() {
        NumberFractionsSumUp1 test = new NumberFractionsSumUp1();
        int result = test.solve(new int[]{1,1,2}, new int[]{3,2,3});
        Assert.assertEquals(1,result);
    }
}
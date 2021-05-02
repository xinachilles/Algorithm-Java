package MOA;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxSumNumbersWithSameDigitTest {

    @Test
    public void findSum() {
        MaxSumNumbersWithSameDigit test = new MaxSumNumbersWithSameDigit();
        int result = test.findSum(new int[]{42,33,60});
        Assert.assertEquals(result,102);
    }
}
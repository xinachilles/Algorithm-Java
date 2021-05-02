package MOA;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaximumPossibleValueTest {

    @Test
    public void maximumPossibleValue() {
        MaximumPossibleValue test = new MaximumPossibleValue();
        int resut = test.MaximumPossibleValue(-999);
        Assert.assertEquals(resut,-5999);
    }
}
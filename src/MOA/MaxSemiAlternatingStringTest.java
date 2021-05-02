package MOA;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxSemiAlternatingStringTest {

    @Test
    public void maxSemiAlternatingString() {
        MaxSemiAlternatingString test = new MaxSemiAlternatingString();
        int result = test.maxSemiAlternatingString("abaaaa");
        Assert.assertEquals(result,4);
    }
}
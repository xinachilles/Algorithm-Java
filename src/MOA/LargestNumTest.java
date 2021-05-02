package MOA;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LargestNumTest {

    @Test
    public void largestNum() {
        LargestNum test = new LargestNum();
        int result =test.largestNum(new int[]{3,2,-2,5,-3});
        Assert.assertEquals(result,3);
    }
}
package MOA;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LargestNumberXTest {

    @Test
    public void getLargeNum() {
        LargestNumberX test = new LargestNumberX();
        int result = test.getLargeNum(new int[] {5,5,5,5,5});
        Assert.assertEquals(result,5);
    }
}
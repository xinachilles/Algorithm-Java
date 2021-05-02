package MOA;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FairIndexTest {

    @Test
    public void fairIndex() {
        FairIndex test =new FairIndex();
        int result = test.fairIndex(new int[]{2,-2,-3,3},new int[]{0,0,4,-4});
        Assert.assertEquals(result,1);
    }
}
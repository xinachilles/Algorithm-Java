package MOA;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxNetworkRankTest {

    @Test
    public void maxNetworkRank() {
        MaxNetworkRank test = new MaxNetworkRank();
        int result = test.maxNetworkRank(new int[]{1,2,3,3},new int[]{2,3,1,4},4);
        Assert.assertEquals(result,4);
    }
}
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 12/10/16.
 */
public class CoinChangeTest {
    @Test
    public void coinChange() throws Exception {
            CoinChange target = new CoinChange();
            target.coinChange(new int[]{2},3);
    }

    @Test
    public void coinChange2() {
        CoinChange test = new CoinChange();
        test.coinChange2(new int[]{1,2,5},11);
    }
}
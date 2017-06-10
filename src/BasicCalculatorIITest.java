import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 4/23/17.
 */
public class BasicCalculatorIITest {
    @Test
    public void calculate() throws Exception {
        BasicCalculatorII target = new BasicCalculatorII();
        target.calculate("2*2+3*3");
    }

}
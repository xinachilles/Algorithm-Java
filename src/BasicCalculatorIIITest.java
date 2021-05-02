import org.junit.Test;

import static org.junit.Assert.*;

public class BasicCalculatorIIITest {

    @Test
    public void calculate() {
        BasicCalculatorIII test = new BasicCalculatorIII();
        test.calculate("6-4 / 2");
    }
}
package AmazonOA;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ShoppingPatternTest {

    @Test
    public void getShoppingPatternsTrioMinimum() {
        ShoppingPattern test = new ShoppingPattern();
        int min = test.getShoppingPatternsTrioMinimum(6, Arrays.asList(1,2,2,3,4,5), Arrays.asList(2,4,5,5,5,6));
        assertEquals(min,3);
    }
}
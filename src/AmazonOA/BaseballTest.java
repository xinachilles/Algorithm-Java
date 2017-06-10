package AmazonOA;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 4/14/17.
 */
public class BaseballTest {
    @Test
    public void test1() throws Exception {
        Baseball target = new Baseball();
        target.test(new String[]{"5", "-2", "4", "Z", "X", "9", "+", "+"});
    }

}
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 12/10/16.
 */
public class MaxSquareTest {
    @Test
    public void maximalSquare() throws Exception {
        MaxSquare target = new MaxSquare();
       target.maximalSquare( new char[][] {"10100".toCharArray(),"10111".toCharArray(),"11111".toCharArray(),"10010".toCharArray()});
        //target.maximalSquare(new char[][]{"1".toCharArray()});
    }

}
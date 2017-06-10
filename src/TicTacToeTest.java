import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 4/23/17.
 */
public class TicTacToeTest {
    @Test
    public void move() throws Exception {
        TicTacToe target = new TicTacToe(3);
        target.move(1,1,2);
        target.move(0,2,2);
        target.move(2,0,2);
    }

}
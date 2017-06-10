import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 3/10/17.
 */
public class MinesweeperTest {
    @Test
    public void updateBoard() throws Exception {
        Minesweeper target = new Minesweeper();
        target.updateBoard( new char[][] { "EEEEE".toCharArray(),"EEMEE".toCharArray(),"EEEEE".toCharArray(),"EEEEE".toCharArray()}, new int[]{3,0});
    }

}
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 4/23/17.
 */
public class MinesweeperDFSTest {
    @Test
    public void updateBoard() throws Exception {
        MinesweeperDFS target = new MinesweeperDFS();
        target.updateBoard(new char[][]{"EEEEE".toCharArray(), "EEMEE".toCharArray(),"EEEEE".toCharArray(),"EEEEE".toCharArray()},new int[]{3,0});
    }

}
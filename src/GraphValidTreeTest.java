import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 12/26/16.
 */
public class GraphValidTreeTest {
    @Test
    public void validTree1() throws Exception {

    }

    @Test
    public void validTree() throws Exception {
        GraphValidTree target = new GraphValidTree();
        target.validTree(5,new int[][] {new int[]{0,1},new int[] {0,2}, new int[] {2,3}, new int[] {2,4} });
    }

}
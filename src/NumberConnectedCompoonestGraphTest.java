import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 10/9/16.
 */
public class NumberConnectedCompoonestGraphTest {
    @Test
    public void countComponetns() throws Exception {
            NumberConnectedCompoonestGraph target = new NumberConnectedCompoonestGraph();
            int[][] edges = new int[][]{new int[]{0,1},new int[]{1,2},new int[]{2,3},new int[]{3,4}};
            target.countComponetns(5,edges);
    }

}
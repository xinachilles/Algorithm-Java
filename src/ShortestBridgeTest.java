import org.junit.Test;

import static org.junit.Assert.*;

public class ShortestBridgeTest {

    @Test
    public void shortestBridge() {
        ShortestBridge test = new ShortestBridge();
        test.shortestBridge(new int[][]{{0,1},{1,0}});
    }
}
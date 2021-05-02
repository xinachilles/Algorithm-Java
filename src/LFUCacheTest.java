import org.junit.Test;

import static org.junit.Assert.*;

public class LFUCacheTest {

    @Test
    public void get() {
//["LFUCache","put","put","get","get","put","get","get","get"]
//[[2],[2,1],[3,2],[3],[2],[4,3],[2],[3],[4]]
        LFUCache test = new LFUCache(2);
        test.put(2, 1);
        test.put(3, 2);
        test.get(3);
        test.get(2);
        test.put(4, 3);
        test.get(2);

    }
}
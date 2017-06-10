import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 3/19/17.
 */
public class LRUCacheTest {
    @Test

// [[3],[2,2],[1,1],[2],[1],[2],[3,3],[4,4],[3],[2],[1],[4]]
    public void put() throws Exception {
        LFUCache lru = new LFUCache(3);
        lru.put(2,2);
        lru.put(1,1);
        lru.get(2);
        lru.get(1);
        lru.get(2);

        lru.put(3,3);
        lru.put(4,4);

        lru.get(3);
        lru.get(2);
        lru.get(1);
        lru.get(4);




    }

}
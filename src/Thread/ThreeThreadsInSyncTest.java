package Thread;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 6/4/17.
 */
public class ThreeThreadsInSyncTest {
    @Test
    public void test() throws Exception {
        ThreeThreadsInSync target = new ThreeThreadsInSync();
        ThreeThreadsInSync.main(new String[]{});
    }

}
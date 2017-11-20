import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 7/2/17.
 */
public class TaskSchedulerTest {
    @Test
    public void leastInterval() throws Exception {
        TaskScheduler target = new TaskScheduler();
        target.leastInterval(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'},2);
    }

}
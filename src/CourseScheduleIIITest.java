import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 10/19/16.
 */
public class CourseScheduleIIITest {
    @Test
    public void findOrder() throws Exception {
        CourseScheduleIII target = new CourseScheduleIII();
        target.findOrder(2, new int[][]{{1,0}});
    }

}
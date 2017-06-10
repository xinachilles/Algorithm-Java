import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 9/26/16.
 */
public class CourseScheduleTest {

    @Test
    public void testCanFinish() throws Exception {
        CourseSchedule target = new CourseSchedule();
        int[][] courses = {{1,0}};
        target.canFinish(2,courses);
    }
}
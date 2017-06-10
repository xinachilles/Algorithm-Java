import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 11/11/16.
 */
public class CourseScheduleDFSTest {
    @Test
    public void canFinish() throws Exception {
        CourseScheduleDFS target = new CourseScheduleDFS();
        target.canFinish(3,new int[][]{new int[]{1,0}, new int[]{2,0}, new int[]{0,1}});
    }

}
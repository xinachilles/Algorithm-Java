package DOA;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ScheduleTest {

    @Test
    public void schedule() {
        Schedule test = new Schedule();
        int[][] bookings = new int[][]{new int[]{0, 10}, new int[]{5,15}, new int[]{20, 30}, new int[]{40, 50}};
        List<int[]> result = test.schedule(Arrays.asList(bookings),-5,60,8);
    }
}
import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumDifficultyJobScheduleTest {

    @Test
    public void minDifficulty() {
         MinimumDifficultyJobSchedule test = new MinimumDifficultyJobSchedule();
         test.minDifficulty(new int[]{6,5,4,3,2,1},2);
    }
}
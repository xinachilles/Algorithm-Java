package MOA;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 6/9/17.
 */
public class TimeTest {
    @Test
    public void findTime() throws Exception {
        Time target = new Time();
        target.FindTime("12:21");
    }

}
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 11/17/16.
 */
public class CompareVersionNumbersTest {
    @Test
    public void compareVersion() throws Exception {
        CompareVersionNumbers target = new CompareVersionNumbers();
        target.compareVersion("1","0");
    }

}
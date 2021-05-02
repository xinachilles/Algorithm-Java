import org.junit.Test;

import static org.junit.Assert.*;

public class StreamCheckerTest {

    @Test
    public void query() {
        StreamChecker test = new StreamChecker(new String[]{"cd","f","kl"});
        test.query('c');
        test.query('d');

    }
}
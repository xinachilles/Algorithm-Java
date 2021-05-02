import org.junit.Test;

import static org.junit.Assert.*;

public class StringReplaceFBTest {

    @Test
    public void replace() {
        StringReplaceFB test = new StringReplaceFB();
        String result = test.replace("abc%20def","%20","1111");

    }
}
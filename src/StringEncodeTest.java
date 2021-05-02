import org.junit.Test;

import static org.junit.Assert.*;

public class StringEncodeTest {

    @Test
    public void encode() {
        StringEncode  test = new StringEncode();
        String result =  test.encode("yahoo/q?flo wer mar  ket ");

    }
}
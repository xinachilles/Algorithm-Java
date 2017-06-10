import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 4/30/17.
 */
public class EncodeDecodeTinyURLTest {
    @Test
    public void encode() throws Exception {
     EncodeDecodeTinyURL target=  new EncodeDecodeTinyURL();
     String shortUrl = target.encode("https://leetcode.com/problems/design-tinyurl");
     String longUrl = target.decode(shortUrl);
    }

}
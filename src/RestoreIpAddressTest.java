import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 10/23/16.
 */
public class RestoreIpAddressTest {
    @Test
    public void resotreIPAddresses() throws Exception {
        RestoreIpAddress target = new RestoreIpAddress();
        target.resotreIPAddresses("0000");
    }

}
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidateIPAddressTest {

    @Test
    public void validIPAddress() {
        ValidateIPAddress test = new ValidateIPAddress();
        test.validIPAddress("172.16.254.1");
    }
}
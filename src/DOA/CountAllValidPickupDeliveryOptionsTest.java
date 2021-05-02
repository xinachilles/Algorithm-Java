package DOA;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CountAllValidPickupDeliveryOptionsTest {

    @Test
    public void countOrders() {
        CountAllValidPickupDeliveryOptions test = new CountAllValidPickupDeliveryOptions();
        List<List<String>> result =  test.countOrders(2);
    }
}
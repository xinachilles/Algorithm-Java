import org.junit.Test;

import static org.junit.Assert.*;

public class CarFleetIITest {

    @Test
    public void getCollisionTimes() {
        CarFleetII test = new CarFleetII();
        double []result= test.getCollisionTimes(new int[][]{{3,4},{5,4},{6,3},{9,1}});

    }
}
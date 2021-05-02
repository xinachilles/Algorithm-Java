import org.junit.Test;

import static org.junit.Assert.*;

public class RangeModuleTest {

    @Test
    public void removeRange() {
     //   ["RangeModule","addRange","removeRange","queryRange","queryRange","queryRange"]
//[[],[10,20],[14,16],[10,14],[13,15],[16,17]]
        RangeModule2 test = new RangeModule2();
        test.addRange(10,20);
      //  test.addRange(1,8);
        test.removeRange(14,16);

    }
}
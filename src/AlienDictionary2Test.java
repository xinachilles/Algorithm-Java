import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 3/19/17.
 */
public class AlienDictionary2Test {
    @Test
    public void alienOrder() throws Exception {
        AlienDictionary target = new AlienDictionary();
        target.alienOrder(new String[]{"z","x","z"});
    }

}
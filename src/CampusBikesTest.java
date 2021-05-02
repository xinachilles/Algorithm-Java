import org.junit.Test;

import static org.junit.Assert.*;

public class CampusBikesTest {

    @Test
    public void assignBikes() {
        CampusBikes test=  new CampusBikes();
        test.assignBikes( new int[][]{{0,0},{2,1}},new int[][]{{1,2},{3,3}});
    }
}
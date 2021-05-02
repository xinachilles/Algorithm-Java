import org.junit.Test;

import static org.junit.Assert.*;

public class PossibleBipartitionTest {

    @Test
    public void possibleBipartition() {
        PossibleBipartition test = new PossibleBipartition();
        test.possibleBipartition(4,new int[][]{{1,2},{1,3},{2,4}});
    }
}
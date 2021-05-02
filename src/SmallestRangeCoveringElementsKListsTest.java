import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SmallestRangeCoveringElementsKListsTest {

    @Test
    public void smallestRange() {
        SmallestRangeCoveringElementsKLists test = new SmallestRangeCoveringElementsKLists();
        List<List<Integer>> data = new ArrayList<>();
        data.add(Arrays.asList(4,10,15,24,26));
        data.add(Arrays.asList(0,9,12,20));
        data.add(Arrays.asList(5,18,22,30));

        test.smallestRange(data);
    }

}
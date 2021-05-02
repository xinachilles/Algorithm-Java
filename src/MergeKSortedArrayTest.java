import org.junit.Test;

import static org.junit.Assert.*;

public class MergeKSortedArrayTest {

    @Test
    public void merge() {
         MergeKSortedArray test = new MergeKSortedArray();
         test.merge(new int[][]{{1,1,1},{2,2,2},{3,3,3},{1,2,3}});
    }
}
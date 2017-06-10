import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 12/30/16.
 */
public class SequenceReconstructionTest {
    @Test
    public void sequenceReconstruction() throws Exception {
            SequenceReconstruction target = new SequenceReconstruction();
            target.sequenceReconstruction(new int[]{1,2,3}, new int[][]{new int[]{1,2}, new int[]{1,3}});
    }

}
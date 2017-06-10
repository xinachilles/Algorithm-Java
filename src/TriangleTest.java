import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by xhu on 10/30/16.
 */
public class TriangleTest {


    @Test
    public void minimumTotal() throws Exception {
        Triangle target = new Triangle();
        //[[-1],[3,2],[-3,1,-1]]
        List<List<Integer>> data  = new ArrayList<>();

        data.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{-1})));
        data.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{3,2})));
        data.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{-3,1,-1})));

        target.minimumTotal(data);

    }

}
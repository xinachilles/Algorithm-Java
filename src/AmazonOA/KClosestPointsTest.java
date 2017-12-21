package AmazonOA;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xhu on 7/29/17.
 */
public class KClosestPointsTest {
    @Test
    public void kClosest() throws Exception {
        //[[4,6],[4,7],[4,4],[2,5],[1,1]], [0,0], 3
        KClosestPoints target = new KClosestPoints();
        List<Integer> code1 = Arrays.asList(new Integer[]{1,8});
        List<Integer> code2 = Arrays.asList(new Integer[]{2,4});
        List<Integer> code3 = Arrays.asList(new Integer[]{8,9});
        List<Integer> code4 = Arrays.asList(new Integer[]{5,3});
        List<Integer> code5 = Arrays.asList(new Integer[]{2,7});
        List<Integer> code6 = Arrays.asList(new Integer[]{3,5});


        List<List<Integer>> position = new ArrayList<>();
        position.add(code1);
        position.add(code2);
        position.add(code3);
        position.add(code4);
        position.add(code5);
        position.add(code6);

        List<List<Integer>> result = target.kClosestHeap(position,3);



    }

}
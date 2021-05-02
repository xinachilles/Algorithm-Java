package AmazonOA;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class OptimizingBoxWeightsTest {

    @Test
    public void optimizingBoxWeights() {
        OptimizingBoxWeights test = new OptimizingBoxWeights();
        List<Integer> result =  test.optimizingBoxWeights(new int[]{5,3,2,4,1,2 });

    }
}
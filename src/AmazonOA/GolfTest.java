package AmazonOA;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class GolfTest {

    @Test
    public void cutOffTree() {



            Golf test = new Golf();

            List<Integer> level1 = Arrays.asList(new Integer[] {1,3,0,2});

            List<Integer> level2 = Arrays.asList(new Integer[] {1,1,3,1});

            List<List<Integer>> level = new ArrayList<>();

            level.add(level1);

            level.add(level2);



            int result = test.cutOffTree(level);

        }
    }

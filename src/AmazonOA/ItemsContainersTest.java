package AmazonOA;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ItemsContainersTest {

    @Test
    public void numberOfItems() {
        ItemsContainers test = new ItemsContainers();
        List<Integer> result = test.numberOfItems("*|*|*|", Arrays.asList(1),Arrays.asList(6));
    }
}
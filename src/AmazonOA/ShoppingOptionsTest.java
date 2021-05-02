package AmazonOA;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ShoppingOptionsTest {
    @Test
    public void getOptions(){
        ShoppingOptions test = new ShoppingOptions();

        int[]a = new int[]{2,3};
        int[]b = new int[]{4};
        int[]c = new int[]{2,3};
        int[]d = new int[]{1,2};

        int rest = test.getOptions(a,b,c,d,10);
        Assert.assertEquals(4,rest);

    }



}
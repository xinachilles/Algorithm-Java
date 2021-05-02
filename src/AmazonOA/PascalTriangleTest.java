package AmazonOA;

import org.junit.Test;

import static org.junit.Assert.*;

public class PascalTriangleTest {

    @Test
    public void generate() {

        PascalTriangle target = new PascalTriangle();
        target.generate(3);
    }
}
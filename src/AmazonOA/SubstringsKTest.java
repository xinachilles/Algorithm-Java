package AmazonOA;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SubstringsKTest {

    @Test
    public void computeSubStrings() {
        SubstringsK test = new SubstringsK();
        List<String> result=  test.computeSubStrings("wawaglknagagwunagkwkwagl",4);
    }
}
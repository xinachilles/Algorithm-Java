package AmazonOA;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SubStringKDistTest {

    @Test
    public void subStringKDist() {
        SubStringKDist target = new SubStringKDist();
        target.subStringKDist("awaglknagawunagwkwagl",4);
    }

    @Test
    public void subStringK1Dist() {
        SubStringKDist target = new SubStringKDist();
        List<String> result = target.subStringK1Dist("wokaoleyama",4);
    }
}
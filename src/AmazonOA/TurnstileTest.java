package AmazonOA;

import org.junit.Test;

import static org.junit.Assert.*;

public class TurnstileTest {

    @Test
    public void getTimes() {
        Turnstile test = new Turnstile();
        int[]result = test.getTimes(5, new int[]{0,1,1,3,3},new int[]{0,1,0,0,1});
    }
}
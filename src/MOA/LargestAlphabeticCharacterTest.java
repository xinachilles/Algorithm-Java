package MOA;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LargestAlphabeticCharacterTest {

    @Test
    public void largestCharacter() {
        LargestAlphabeticCharacter test = new LargestAlphabeticCharacter();
        String result = test.largestCharacter("admeDCAB");
        Assert.assertEquals(result,"D");

    }
}
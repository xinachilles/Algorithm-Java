package MOA;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidWordAbbreviationTest {

    @Test
    public void validWordAbbreviation() {
        ValidWordAbbreviation test = new ValidWordAbbreviation();
        test.validWordAbbreviation("internationalization", "i12iz4n");
    }
}
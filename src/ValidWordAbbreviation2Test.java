import org.junit.Test;

import static org.junit.Assert.*;

public class ValidWordAbbreviation2Test {

    @Test
    public void validWordAbbreviation() {
        ValidWordAbbreviation2 test = new ValidWordAbbreviation2();
        boolean result = test.validWordAbbreviation("internationalization",
                "i5a11o1");
    }
}
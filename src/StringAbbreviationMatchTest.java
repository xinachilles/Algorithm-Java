import org.junit.Test;

import static org.junit.Assert.*;

public class StringAbbreviationMatchTest {

    @Test
    public void match() {
        StringAbbreviationMatch test = new StringAbbreviationMatch();
        test.match("laioffercom","l10");
    }
}
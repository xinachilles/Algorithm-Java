import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 10/22/16.
 */
public class ValidWordAbbreviationTest {
    @Test
    //"internationalization"
    //"i12iz4n"
    public void validWordAbbreviation() throws Exception {
        ValidWordAbbreviation target = new ValidWordAbbreviation();
        target.validWordAbbreviation("internationalization","i12iz4n");
    }

}
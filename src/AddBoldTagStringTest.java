import org.junit.Test;

import static org.junit.Assert.*;

public class AddBoldTagStringTest {

    @Test
    public void addBoldTag() {
        AddBoldTagString test = new AddBoldTagString();
        test.addBoldTag("abcxyz123", new String[]{"abc","123"});

    }
}
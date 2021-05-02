import org.junit.Test;

import static org.junit.Assert.*;

public class WordSearchII2Test {

    @Test
    public void findWords() {
        WordSearchII2 test = new WordSearchII2();
        test.findWords(new char[][]{new char[]{'a'}},new String[]{"a"} );
    }
}
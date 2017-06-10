import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 4/29/17.
 */
public class IntegerEnglishWordsTest {
    @Test
    public void numberToWords() throws Exception {
        IntegerEnglishWords target = new IntegerEnglishWords();
        target.numberToWords(123456789);
    }

}
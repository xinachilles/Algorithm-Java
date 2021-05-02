import org.junit.Test;

import static org.junit.Assert.*;

public class TopKFrequentWordsTest {

    @Test
    public void topKFrequent() {
        TopKFrequentWords test = new TopKFrequentWords();
        test.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"},2);
    }
}
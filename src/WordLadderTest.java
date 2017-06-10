import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by xhu on 1/4/17.
 */
public class WordLadderTest {
    @Test
    public void ladderLength() throws Exception {
        WordLadder target = new WordLadder();
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dog");
        wordList.add("dot");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");





       target.ladderLength("hit","cog", wordList );
    }

}
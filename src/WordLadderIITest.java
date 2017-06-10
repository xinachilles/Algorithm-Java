import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by xhu on 10/13/16.
 */
public class WordLadderIITest {
    @Test
    public void findLadders() throws Exception {
         WordLadderII target = new WordLadderII();
         List<String> wordSet = new ArrayList<String>(Arrays.asList("hot","dot","dog","lot","log","cog"));
         target.findLadders("hit","cog",wordSet);


    }

}
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 11/13/16.
 */
public class TrieTest {


    @Test
    //search("ab"),insert("ab"),search("ab"),search("ab"),startsWith("ab"),startsWith("ab")
    public void insert() throws Exception {
        Trie target = new Trie();
        target.insert("app");
        target.insert("apple");
        target.search("apple");

    }

    @Test
    public void search() throws Exception {

    }

    @Test
    public void startsWith() throws Exception {

    }

}
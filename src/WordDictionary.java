import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 11/13/16.
 */
class wordDictionary
{

    Trie trie;

    public wordDictionary()
    {
        trie = new Trie();
    }

    public void addWord(String word)
    {
        trie.insert(word);
    }

    public boolean search(String word)
    {
       return trie.search(word);
    }



    }




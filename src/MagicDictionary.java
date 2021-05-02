import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MagicDictionary {
    /**
     * Initialize your data structure here.
     */
    // key is *ello, h*llo ..
    // value is which letter is replaced by *. like h or o...
    HashMap<String, Set<Character>> wordMap;

    public MagicDictionary() {
        wordMap = new HashMap<>();
    }

    /**
     * Build a dictionary through a list of words
     */
    public void buildDict(String[] dict) {
        for (String d : dict) {
            for (int i = 0; i < d.length(); i++) {
                String word = d.substring(0, i) + "*" + d.substring(i + 1, d.length());
                if (!wordMap.containsKey(word)) {
                    wordMap.put(word, new HashSet<>());
                }
                wordMap.get(word).add(d.charAt(i));
            }
        }

    }

    /**
     * Returns if there is any word in the trie that equals to the given word after modifying exactly one character
     */
    public boolean search(String word) {
        for (int i = 0; i < word.length(); i++) {
            String a = word.substring(0, i) + "*" + word.substring(i + 1, word.length());
            if (wordMap.containsKey(a) && (!wordMap.get(a).contains(word.charAt(i)) || wordMap.get(a).size()>1) ) return true;
        }
        return false;
    }

}

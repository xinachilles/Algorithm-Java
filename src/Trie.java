import javax.swing.plaf.PanelUI;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by xhu on 11/13/16.
 */
class TrieNode {

    // boolean isWord;
    public TrieNode[] next = new TrieNode[26];
    public String value = null;

    public TrieNode(String word) {
        this.value = word;
    }

    public TrieNode() {
    }


}

public class Trie {
    public TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        root = insert(root, word, 0);
    }

    private TrieNode insert(TrieNode root, String word, int index) {

        if (root == null) {
            root = new TrieNode();

        }

        if (index == word.length()) {
            root.value = word;
            return root;
        }


        root.next[word.charAt(index) - 'a'] = insert(root.next[word.charAt(index) - 'a'], word, index + 1);

        return root;

    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = search(root, word, 0);

        if (node == null || node.value == null) {
            return false;
        } else {
            return true;
        }
    }

    private TrieNode search(TrieNode root, String prefix, int index) {
        if (root == null || index == prefix.length()) {
            return root;
        }


        return search(root.next[prefix.charAt(index) - 'a'], prefix, index + 1);

    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = search(root, prefix, 0);
        return node != null;
    }

    public List<String> searchAllPrefix(String prefix) {
        TrieNode start = search(root, prefix, 0);
        List<String> result = new ArrayList<>();
        if (start == null) {
            return result;
        }

        searchAllPrefix(start, result);

        return result;
    }

    private void searchAllPrefix(TrieNode start, List<String> result) {
        if (start == null) {
            return;
        }

        Queue<TrieNode> visiting = new LinkedList<>();
        visiting.offer(start);

        while (!visiting.isEmpty()) {
            TrieNode current = visiting.poll();
            if (current.value != null || current.value.length()>0 ) {
                result.add(current.value);
            }

            for (TrieNode n : current.next) {
                if (n != null) {
                    visiting.offer(n);
                }
            }
        }
    }
}

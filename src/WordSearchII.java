import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xhu on 11/5/16.
 */
public class WordSearchII {
    class TrieNode {

        // boolean isWord;
        public TrieNode[] children;
        public String value;


        public TrieNode() {
            children = new TrieNode[26];
            value = null;
        }

        public void insert(String word, int index) {
            if (index == word.length()) {
                value = word;
                return;
            }

            int pos = word.charAt(index) - 'a';
            if (children[pos] == null) {
                children[pos] = new TrieNode();
            }
            children[pos].insert(word, index + 1);
        }

        private TrieNode search(String prefix, int index) {
            if (prefix.length() == index) {
                return this;
            }
            int pos = prefix.charAt(index) - 'a';
            if (children[pos] == null) {
                return null;
            }
            return children[pos].search(prefix, index + 1);
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        if (board == null || board.length == 0 || words == null) {
            return result;
        }

        TrieNode root = new TrieNode();
        for (String w : words) {
            root.insert(w, 0);
        }


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                search(board, i, j, root.children[board[i][j] - 'a'], result);
            }
        }

        return result;
    }

    private void search(char[][] board, int i, int j, TrieNode root, List<String> result) {

        if (root == null) {
            return;
        }
        if (root.value != null && !result.contains(root.value)) {
            result.add(root.value);

        }


        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }


        char value = board[i][j];
        board[i][j] = '#';
        if (i - 1 >= 0 && board[i - 1][j] != '#') {
            search(board, i - 1, j, root.children[board[i - 1][j] - 'a'], result);
        }

        if (i + 1 < board.length && board[i + 1][j] != '#') {
            search(board, i + 1, j, root.children[board[i + 1][j] - 'a'], result);
        }

        if (j - 1 >= 0 && board[i][j - 1] != '#') {
            search(board, i, j - 1, root.children[board[i][j - 1] - 'a'], result);
        }

        if (j + 1 < board[0].length && board[i][j + 1] != '#') {
            search(board, i, j + 1, root.children[board[i][j + 1] - 'a'], result);
        }

        board[i][j] = value;


    }


}



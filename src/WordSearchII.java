import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xhu on 11/5/16.
 */
public class WordSearchII {
    // word search ii
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        if (board == null || board.length == 0 || words == null)
        {
            return result;
        }

        Trie trie = new Trie();
        for (String w : words)
        {
            trie.insert(w);
        }


        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                search(board, i, j, trie.root, result, "");
            }
        }

        return result;
    }

    private void search(char[][]board,int i, int j, TrieNode root,List<String> result,String word){

        if(root.value.equals(word) && !result.contains(word)){
            result.add(word);

        }


        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
        {
            return;
        }

        if(board[i][j] == '#'){
            return;
        }


        char value = board[i][j];
        board[i][j] = '#';
        search(board, i - 1, j, root.next[value-'a'],  result,word+value);
        search(board, i + 1, j, root.next[value-'a'], result,word+value);
        search(board, i, j-1, root.next[value-'a'], result,word+value);
        search(board, i, j+1, root.next[value-'a'],  result,word+value);
        board[i][j] = value;


    }
}

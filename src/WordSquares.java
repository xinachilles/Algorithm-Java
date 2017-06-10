import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 11/10/16.
 */
public class WordSquares {

    //word squares
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> result = new ArrayList<>();
        if (words == null || words.length == 0) {
            return result;
        }
        Trie trie = new Trie();

        for (String w : words) {
            trie.insert(w);
        }

        wordSquaresHelper(trie, words, new ArrayList<String>(), result);
        return result;
    }

    private void wordSquaresHelper(Trie trie, String[] words, List<String> solution, List<List<String>> result) {
        if (solution.size() == words[0].length()) {
            result.add(new ArrayList<String>(solution));
            return;
        }



            String prefix = getPrefix(solution);
            List<String> allPrefix = trie.searchAllPrefix(prefix);
            if(allPrefix == null || allPrefix.size()==0){
                return;
            }
            for (String a : allPrefix) {
                solution.add(a);
                wordSquaresHelper(trie, words, solution, result);
                solution.remove(solution.size() - 1);
            }


    }

    private String getPrefix(List<String> solution) {
        if (solution == null || solution.size() == 0) {
            return "";
        }

        StringBuffer result = new StringBuffer();
        int index = solution.size();
        for (int i = 0; i < solution.size() && index < solution.get(i).length(); i++) {
            result.append(solution.get(i).charAt(index));

        }

        return result.toString();

    }

}

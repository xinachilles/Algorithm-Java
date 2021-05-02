import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xhu on 11/10/16.
 */
public class WordSquares {
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> result = new ArrayList<>();
        if (words == null || words.length == 0) {
            return result;
        }
        helper(words,result,new ArrayList<>());
        return result;
    }

    private void helper(String[] words,List<List<String>> result,List<String> solution){
        if(solution.size() == words[0].length()){
            result.add(new ArrayList<>(solution));
            return;
        }

        Set<String> used = new HashSet<>();

        for(int i = 0; i<words.length;i++){
            if(!used.contains(words[i]) && isValid(words[i],solution)){
                used.add(words[i]);
                solution.add(words[i]);
                helper(words,result,solution);
                solution.remove(solution.size()-1);
            }

        }

    }

    private boolean isValid(String word,List<String> solution){
        if(solution.isEmpty()) return true;
        int index = 0;
        int row  = solution.size();

        for(int i = 0; i<row && row<solution.get(i).length();i++){

            if(word.charAt(index)!=solution.get(i).charAt(row)){
                return false;
            }
            index++;
        }
        return true;


    }



}

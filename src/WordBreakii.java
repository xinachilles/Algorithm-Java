import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by xhu on 11/5/16.
 */
public class WordBreakii {
    // word break ii
    public List<String> wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0) {
            return null;
        }
        Map<String, List<String>> maps = new HashMap<>();
        return helper(s,wordDict,maps);
    }

    public List<String> helper(String s, Set<String> wordDict, Map<String,List<String>> memo){
        List<String> result = new ArrayList<>();
        if(s == null || s.length() == 0){
            result.add("");
            return result;
        }
        if(memo.containsKey(s)) return memo.get(s);
        for(String word: wordDict){
           if(s.startsWith(word)){
               List<String> sub = helper(s.substring(word.length()), wordDict,memo);
               for(String substring : sub){
                   String optionalSpace = substring.length() ==0? "": " ";
                   result.add(word+ optionalSpace+substring);
               }
           }
        }
        memo.put(s,result);
        return result;
    }


}

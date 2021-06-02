package IndeedOnsite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
* You may assume the dictionary does not contain duplicate words.
* */
public class WordBreakII {
    //catsanddog, try each possible position to find the first word in the dic. we start with c if c is in the dic, then we put the rest of the sentence to the function as the
    // input, to find out all the possible subset for that sentence -- all the word in the subset should be in the dic and the all word combine togeter is that sentence
    // we can use a memorization map to remember the result, we have search the sentence before, we can return the result directly from
    // the map

    // time is O(len(s)^ len(s/minwordlenindic)
    // O(len(worddict) ^ len(s/minwordlenindic) len(worddict) possibilites for each cut
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        Map<String,List<String>> mem = new HashMap<>();
        return helper(s,wordDict,mem);
    }

    private List<String> helper(String s,List<String> wordDic,Map<String,List<String>> mem){
        if(s == null || s.length() ==0){
            return null;
        }
        if(mem.containsKey(s)){
            return mem.get(s);
        }
        mem.put(s, new ArrayList<>());
        if(wordDic.contains(s)){
            mem.get(s).add(s);
        }

        for(int i = 1; i<=s.length();i++){
            String sub = s.substring(0,i);
            if(wordDic.contains(sub)){
                List<String> rest = helper(s.substring(i),wordDic,mem);
                if(rest == null) continue;
                for(String r: rest){
                    mem.get(s).add(sub+" "+r);
                }
            }
        }
        return mem.get(s);
    }
}

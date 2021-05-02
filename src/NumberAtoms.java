import java.util.*;

public class NumberAtoms {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0){
            return null;
        }

        List<List<String>> result = new ArrayList<>();
        HashMap<String,List<String>> maps = new HashMap<>();

        for(String str : strs){
            String key = SortString(str);
            if(!maps.containsKey(key)){
                maps.put(key,new ArrayList<>());
            }

            maps.get(key).add(str);
        }

        for(String key: maps.keySet()){
            result.add(maps.get(key));
        }

        return result;
    }

    private String SortString(String s){
        if(s == null || s.length() == 0){
            return s;
        }

        int[] letters = new int[26];
        for(int i = 0; i<s.length();i++){
            letters[s.charAt(i)-'a'] ++;
        }

        StringBuilder result = new StringBuilder();
        for(int i = 0; i<26;i++){
            for(int j = 0; j<letters[j];j++){
                result.append('a'+i);
            }
        }

        return result.toString();
    }
}

import java.util.HashMap;

public class LongestSubstringKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int[] hash = new int[26];
        for(char c: s.toCharArray()){
            hash[c-'a']++;
        }
        int end = 0;
        for(; end<s.length();end++){
            if( hash[s.charAt(end)-'a']<k ){
                break;
            }
        }
        if (end == s.length()) return end;
        int max = 0;
        int start = 0;
        while (end<s.length()){
            if(hash[s.charAt(end)]<k) {
                max = Math.max(max, longestSubstring(s.substring(start, end - 1), k));
                start = end + 1;
            }
            end++;
        }

        return Math.max(max, longestSubstring(s.substring(start),k));

    }

    private boolean AllGreaterThan(HashMap<Character,Integer> maps, int k){

        for(Character key: maps.keySet()){
            if(maps.get(key) <k){
                return false;
            }
        }
        return true;
    }
}

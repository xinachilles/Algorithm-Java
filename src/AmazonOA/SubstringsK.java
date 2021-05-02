package AmazonOA;

import java.util.*;

public class SubstringsK {
    public List<String> computeSubStrings(String S, int k) {
        if(S == null || S.length() == 0) {
            return Collections.emptyList();
        }
        Set<String> subString = new HashSet<String>();
        Map<Character, Integer> freq = new HashMap<>();
        int left =0;
        for(int i =0; i < S.length(); i++) {
            char r= S.charAt(i);
            freq.put(r, freq.getOrDefault(r, 0)+1);
            // keep that number of distinct chars in the windows be k-1
            while(freq.size()>k-1){
                char l = S.charAt(left++);
                freq.put(l, freq.get(l)-1);
                if(freq.get(l) == 0){
                    freq.remove(l);
                }

            }

            while (i-left+1 >k){
                char l = S.charAt(left++);
                freq.put(l, freq.get(l)-1);
                if(freq.get(l) == 0){
                    freq.remove(l);
                }
            }

            if(i-left+1 == k && freq.size()==k-1){
                subString.add(S.substring(left,i+1));
            }


        }
        return new ArrayList<>(subString);
    }
}

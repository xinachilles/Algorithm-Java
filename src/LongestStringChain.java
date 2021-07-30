import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain {

    public int longestStrChain(String[] words) {
        int max = 0;
        Arrays.sort(words,(a,b)->a.length()-b.length());
       // dp["word"] = j  means the longest word chain end with "word" is j
        Map<String, Integer> dp = new HashMap<>();
        for(String word:words){
            int length =1;
            for(int i = 0; i<word.length();i++){
                String predecessor = word.substring(0,i)+word.substring(i+1,word.length());
                if(dp.containsKey(predecessor)){
                   length= Math.max(length,dp.get(predecessor)+1);
                }
            }
            dp.put(word,length);
            max = Math.max(max,length);
        }

        return max;
    }


}

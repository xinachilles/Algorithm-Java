import java.util.HashMap;
import java.util.Map;

/**
 * Created by xhu on 3/11/17.
 */
public class LongestPalindrome2 {

    public int longestPalindrome(String s) {
        // Write your code here

        if(s == null || s.length() == 0){
            return 0;
        }

        Map<Character,Integer> counts = new HashMap<>();

        for(Character s1 : s.toCharArray()){
            if(counts.containsKey(s1)){
                counts.put(s1,counts.get(s1)+1);
            }else{
                counts.put(s1,1);
            }
        }


        int length = 0;

        for(Character key : counts.keySet()){
            length = length + counts.get(key)/2;
        }

        return s.length()%2 == 0? length:length+1;


    }
}

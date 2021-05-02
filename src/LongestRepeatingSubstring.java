import java.util.HashSet;
import java.util.Set;

public class LongestRepeatingSubstring {
    int max  =0;
    public int longestRepeatingSubstring(String S) {
        // use binary search find the longest repeating string
       for(int i = 0;i<S.length()-1;i++){
           for(int j = 1+1;j<S.length();i++){
               int length  = 0;
               while(i+length<S.length() && j+length<S.length() && S.charAt(i+length)<S.charAt(j+length)){
                   length++;
                   max = Math.max(max,length);
               }
           }
       }
       return max;
    }


}

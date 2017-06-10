import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 5/27/17.
 */
public class PermutationString {
    public boolean checkInclusion(String s1, String s2) {
        if(s1 == null && s2 == null){
            return true;
        }

        if(s1 == null || s2 == null){
            return false;
        }

        int[] counts = new int[26];

        for(int i =0; i<s1.length();i++){
            counts[s1.charAt(i)-'a']++;
            counts[s2.charAt(i)-'a']--;
        }

        if(AllZero(counts)){
            return true;
        }

        for(int i = s1.length(); i<s2.length();i++){
            counts[s2.charAt(i)-'a']--;
            counts[s2.charAt(i-s1.length())-'a']++;
            if(AllZero(counts)){
                return true;
            }
        }

        return false;
    }

    private boolean AllZero(int[] counts){
        for(int i = 0; i<counts.length; i++){
            if(counts[i]>0 || counts[i]<0){
                return false;
            }
        }

        return true;
    }
}

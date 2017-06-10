import java.util.HashSet;
import java.util.Set;

/**
 * Created by xhu on 10/6/16.
 */
public class ReverseVowelsString {
    public String reverseVowels(String s){
        Set<Character> vowel = new HashSet<>();
        vowel.add('a');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');
        vowel.add('A');
        vowel.add('I');
        vowel.add('O');
        vowel.add('U');

        int start = 0;
        int end = s.length()-1;
        char[] arrs = s.toCharArray();

        while (start<end){
            char lo = arrs[start];
            char hi = arrs[end];

            if(!vowel.contains(lo)){
                start++;
                continue;
            }

            if (!vowel.contains(hi)){
                end--;
                continue;
            }

            arrs[start] = hi;
            arrs[end] = lo;

            start++;
            end--;


        }

        return new String(arrs);
    }


}

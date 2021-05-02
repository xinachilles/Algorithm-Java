import java.util.*;

/**
 * Created by xhu on 11/10/16.
 */
public class PalindromePermutationII {


    // palindrome permutationii

    // palindrome permutation

    public List<String> generatePalindromes(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }

        // count the number of each character in the S

        int[] mapping = new int[26];

        for (char c : s.toCharArray()) {
            mapping[c-'a']++;
        }

        char mid = '\0';
        char[] keys = new char[s.length() / 2];
        int index = 0;
        for(int i = 0; i<26; i++){
            if(mapping[i] >0 ){
                if (mapping[i] % 2 != 0) {
                    if (mid != '\0') {
                        return result;
                    }
                    mid = (char)(i+'a');
                }
                for (int j = 0; j < mapping[i]/ 2; j++) {
                    keys[index++] = (char)(i+'a');
                }
            }
        }

        List<String> half = new ArrayList<>();
        Permutation(keys,half,0, mid);

        return result;
    }

    private void Permutation(char[] keys, List<String> result,int index, char mid) {
        if (index == keys.length) {
            result.add(buildResult(new String(keys),mid));
            return;
        }
        Set<Character> used = new HashSet<Character>();
        for(int i = index; i<keys.length; i++){
            if(!used.contains(keys[i])) {
                used.add(keys[i]);
                swap(keys, index, i);
                Permutation(keys, result, i + 1,mid);
                swap(keys, i, index);
            }
        }

    }

    private void swap(char[] keys, int a, int b){
        Character temp = keys[a];
        keys[a] = keys[b];
        keys[b] = temp;
    }
    private String buildResult(String s, char mid ){
        if (mid != '\0') {
            return s + mid + new StringBuilder(s).reverse().toString();

        } else {
            return s + new StringBuilder(s).reverse().toString();
        }
    }
}

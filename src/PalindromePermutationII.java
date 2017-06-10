import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        Map<Character, Integer> mapping = new HashMap<>();

        for (Character c : s.toCharArray()) {
            if (!mapping.containsKey(c)) {
                mapping.put(c, 1);
            } else {
                mapping.put(c, mapping.get(c) + 1);
            }
        }

        char mid = '\0';
        Character[] keys = new Character[s.length() / 2];
        int index = 0;
        for (Character key : mapping.keySet()) {

            if (mapping.get(key) % 2 != 0) {
                if (mid != '\0') {
                    return result;
                }

                mid = key;
            }

            for (int i = 0; i < mapping.get(key) / 2; i++) {
                keys[index++] = key;

            }

        }

        List<String> half = new ArrayList<>();
        Permutation(keys, new boolean[keys.length], "", half);

        for (String h : half) {
            StringBuilder whole = new StringBuilder();
            if (mid != '\0') {
                whole.append(h + mid + new StringBuilder(h).reverse().toString());

            } else {
                whole.append(h + new StringBuilder(h).reverse().toString());
            }

            if(!result.contains(whole.toString())){
                result.add(whole.toString());
            }

        }

        return result;


    }


    private void Permutation(Character[] keys, boolean[] visited, String solution, List<String> result) {
        if (solution.length() == keys.length) {
            result.add(solution);
            return;
        }

        for (int i = 0; i < keys.length; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            Permutation(keys, visited, solution.length() == 0 ? String.valueOf(keys[i]) : solution + keys[i], result);
            visited[i] = false;
        }

    }
}

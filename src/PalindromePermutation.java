import java.util.HashMap;
import java.util.Map;

/**
 * Created by xhu on 1/4/17.
 */
public class PalindromePermutation {
    //palindrome permutation
//base on the defination of palindrome,if there exis one more character appear only once or appear odd time in the string, we can not find any palindrome from its permutation. so we can build map, value is character and key count,

    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int count = 0;
        for (Character c : s.toCharArray()) {
            update(c, map);

        }

        for(Character key : map.keySet()){
            if (map.get(key) % 2 == 1) {
                count++;
            }
        }

        return !(count > 1);
    }

    private void update(Character c, Map<Character, Integer> map) {
        if (map.containsKey(c)) {
            map.put(c, map.get(c) + 1);
        } else {
            map.put(c, 1);
        }
    }
}

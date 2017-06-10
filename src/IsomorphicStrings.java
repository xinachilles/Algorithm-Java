import java.util.HashMap;
import java.util.Map;

/**
 * Created by xhu on 9/18/16.
 */
// isomorphic string
// A: 1. does the string only contain letter, lower case, upper case, or it has some special character, case sensitive
// 2. if s is null and t is null,

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() == 0 && t.length() == 0) {
            return true;
        }

        if (s.length() == 0 || t.length() == 0) {
            return true;
        }

        // covert the string to a integer partner,for example, if "aab" -> 112, "ccd" -> 112
        Map<Character, Integer> maps = new HashMap<Character, Integer>();
        int lastCharacter = 0;
        StringBuilder sPartner = new StringBuilder();

        for (Character s1 : s.toCharArray()) {
            if (!maps.containsKey(s1)) {
                maps.put(s1, lastCharacter);
                sPartner.append(String.valueOf(lastCharacter));
                lastCharacter++;
            } else {
                sPartner.append(String.valueOf(maps.get(s1)));
            }
        }

        maps.clear();
        lastCharacter = 0;
        StringBuilder tPartner = new StringBuilder();

        for (Character t1 : t.toCharArray()) {
            if (!maps.containsKey(t1)) {
                maps.put(t1, lastCharacter);
                tPartner.append(String.valueOf(lastCharacter));
                lastCharacter++;
            } else {
                tPartner.append(String.valueOf(maps.get(t1)));
            }
        }

        return tPartner.toString().equals(sPartner.toString());
    }
}

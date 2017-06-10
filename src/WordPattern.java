import java.util.HashMap;
import java.util.Map;

/**
 * Created by xhu on 9/12/16.
 */
public class WordPattern {
    public boolean wordPatteran(String pattern, String str) {
        if ((pattern == null && str == null) || (pattern.length() == 0 && str.length() == 0)) {
            return true;
        }

        if (pattern == null || str == null || str.length() == 0 || pattern.length() == 0) {
            return false;
        }

        Map<String, Character> maps = new HashMap<>();
        String[] strs = str.split(" ");
        if (strs.length != pattern.length()) {
            return false;
        }
        // put will return previous value associate with the key
        for (int i = 0; i < strs.length; i++) {
           if(maps.containsKey(strs[i])){
               if(maps.get(strs[i]) != pattern.charAt(i)){
                   return false;
               }
           }else{
               maps.put(strs[i],pattern.charAt(i));
           }
        }

        return true;
    }
}

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xhu on 12/17/16.
 */
public class UniqueSubstringsWraparoundString {

    public int findSubstringInWraproundString(String p) {
        if (p == null || p.length() == 0) {
            return 0;
        }

        Set<String> sets = new HashSet<>();

        for (int i = 0; i < p.length(); i++) {
            for (int j = i; j < p.length(); j++) {
                if (j == i) {
                    if (!sets.contains(p.charAt(i))) {
                        sets.add((String.valueOf(p.charAt(i))));
                    }
                } else {
                    int current =  (p.charAt(j-1) + 1);


                    if (current > 'z') {
                        current = 'a';
                    }

                    if ((char) current != p.charAt(j)) {
                        break;
                    } else {
                        if (!sets.contains(p.substring(i, j))) {
                            sets.add(p.substring(i, j));
                        }
                    }


                }
            }


        }


        return sets.size();
    }


    private boolean isValidSubsets(String p) {
        if (p == null || p.length() == 0) {
            return false;
        }


        return true;
    }


}

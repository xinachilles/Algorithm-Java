import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 10/8/16.
 */
public class RestoreIPAddresses {
    public List<String> restoreIPaddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }

        restoreIpAddressehelper(s, 1, 0, result, "");
        return result;
    }

    private void restoreIpAddressehelper(String s, int index, int segment, List<String> result, String solution) {

        if (segment == 4) {
            if (index < s.length()) {
                String subString = s.substring(index, s.length());
                if (isValid(subString)) {
                    solution = solution + "." + subString;
                    result.add(solution);
                }
            }
            return;
        }

        for (int i = index; i < s.length() && i <= index + 3; i++) {

            String subString = s.substring(index, i + 1);
            if (isValid(subString)) {
                restoreIpAddressehelper(s, i + 1, segment + 1, result, solution.length() == 0 ? subString : solution + "." + subString);
            }
        }

    }

    private boolean isValid(String s){
        if(s == null || s.length() == 0){
            return false;
        }
        if(s.charAt(0) == '0')
            return s.equals("0"); // to eliminate cases like "00", "10"
        int digit = Integer.valueOf(s);
        return digit >= 0 && digit <= 255;
    }

}

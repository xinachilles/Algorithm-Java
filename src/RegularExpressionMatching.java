/**
 * Created by xhu on 2/19/17.
 */
public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        return isMatchHelper(s, p);

    }

    private boolean isMatchHelper(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }

        if (p.length() == 1) {
            if (s.length() == 1 && p.charAt(0) == '.' || p.charAt(0) == s.charAt(0)) {
                return true;
            }
        }

        if (p.length() > 1) {
            if (p.charAt(1) != '*') {
                if (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
                    return isMatch(s.substring(1), p.substring(1));
                }
            } else {
                if (p.charAt(0) == '.') {
                    return true;
                }

                // * will match zero
                // will match one or more than one preceding element
                if (p.charAt(0) == s.charAt(0)) {
                    for (int i = 1; i < s.length(); i++) {
                        if (isMatchHelper(s.substring(1), p.substring(2))) {
                            return true;
                        }
                    }
                }

                if (isMatchHelper(s, p.substring(2))) {
                    return true;
                }


            }
        }

        return false;
    }

}

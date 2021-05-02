public class MinimumRemoveMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder result = new StringBuilder();
        int left = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
                result.append(s.charAt(i));

            } else if (s.charAt(i) == ')' && right < left) {
                right++;
                result.append(s.charAt(i));
            } else if (s.charAt(i) != ')') {
                result.append(s.charAt(i));
            }

        }

        String s1 = result.toString();
        result = new StringBuilder();
        left = 0;
        right = 0;

        for (int i = s1.length() - 1; i >= 0; i--) {
            if (s1.charAt(i) == ')') {
                right++;
                result.append(s1.charAt(i));
            } else if (s1.charAt(i) == '(' && left < right) {
                left++;
                result.append(s1.charAt(i));
            } else if (s1.charAt(i) != '(') {
                result.append(s1.charAt(i));
            }
        }

        return result.reverse().toString();
    }
}


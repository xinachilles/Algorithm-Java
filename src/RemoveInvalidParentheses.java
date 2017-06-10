import java.util.*;

/**
 * Created by xhu on 2/3/17.
 */
public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null) {
            return result;

        }

        Queue<String> visiting = new LinkedList<>();
        Set<String> visited = new HashSet<String>();
        visiting.offer(s);
        boolean found = false;

        while (!visiting.isEmpty()) {
            String current = visiting.poll();

            if (isValid(current)) {
                result.add(current);
                found = true;
            }

            if(found) continue;

            for (int i = 0; i < current.length(); i++) {
                if (current.charAt(i) != '(' && current.charAt(i) != ')') {
                    continue;
                }
                String t = current.substring(0, i) + current.substring(i + 1);
                if (!visited.contains(t)) {
                    visiting.offer(t);
                    visited.add(t);
                }
            }
        }



        return result;
    }

    private boolean isValid(String s) {
        int leftParenthese = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftParenthese++;
            } else if (s.charAt(i) == ')') {
                if (leftParenthese <= 0) {
                    return false;
                }
                leftParenthese--;
            }
        }

        return leftParenthese == 0;
    }


}

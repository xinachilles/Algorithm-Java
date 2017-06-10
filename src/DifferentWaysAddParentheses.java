import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 2/4/17.
 */
public class DifferentWaysAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();
        if (input == null || input.length() == 0) {
            return result;
        }


        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' ||
                    input.charAt(i) == '-' ||
                    input.charAt(i) == '*') {

                String l = input.substring(0, i);
                String r = input.substring(i + 1);
                List<Integer> left = diffWaysToCompute(l);
                List<Integer> right = diffWaysToCompute(r);

                for (Integer l1 : left) {
                    for (Integer r1 : right) {
                        if (input.charAt(i) == '+') {
                            result.add(l1 + r1);
                        } else if (input.charAt(i) == '-') {
                            result.add(l1 - r1);
                        } else {
                            result.add(l1 * r1);
                        }

                    }
                }
            }
        }
        if (result.size() == 0) {
            result.add(Integer.valueOf(input));
        }

        return result;
    }
}

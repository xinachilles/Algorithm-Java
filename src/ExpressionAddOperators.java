import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 1/5/17.
 */
public class ExpressionAddOperators {

   /* public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return ans;
        }
        char[] operations = {'+', '-', '*'};

        addOperatorsHelper(num, target, 0, operations, ans, 0, "", 0);

        return ans;
    }

    private void addOperatorsHelper(String num, int target, int index, char[] operations, List<String> ans, int result, String solution, int previous) {
        if (result == target && index == num.length()) {
            ans.add(solution);
            return;
        }

        for(int i = index; i<num.length() - 1;i++){
            for (int end = i + 1; end < num.length(); end++) {

                String substring = num.substring(i, end);
                for (int j = 0; j < 3; j++) {
                        char op = operations[j];
                        switch (op) {
                            case '+' :
                            addOperatorsHelper(num, target, end + 1, operations, ans,result + previous,
                                    solution.length() == 0? previous + op + substring : solution + previous + op + substring, Integer.valueOf(substring));
                            break;
                            case '-':
                            addOperatorsHelper(num, target, end + 1, operations,ans, result + Integer.valueOf(previous) - Integer.valueOf(substring),
                                    solution.length() == 0? previous + op + substring : solution + previous + op + substring, null);
                            break;
                            case '*':
                            addOperatorsHelper(num, target, end + 1, operations, ans,result + Integer.valueOf(previous) * Integer.valueOf(substring),
                                    solution.length() == 0 ? previous + op + substring : solution + previous + op + substring, null);


                        }
                    }
                }
            }
        }

    }*/

    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return result;
        }

        String[] operations = new String[]{"+", "-", "*"};
        helper(num, "", operations, 0, target, 0, 0, result);
        return result;
    }

    private void helper(String num, String solution, String[] operations, int start, int target, float sum, float previous, List<String> result) {
        if (target == sum) {
            if (solution.length() > 0 && !result.contains(solution)) {
                result.add(solution);
            }

            return;
        }

        for (int i = 1; i + start <=num.length(); i++) {

            String substring = num.substring(start, i + start);
            if(substring.length()>1 && substring.charAt(0) =='0'){
                continue;
            }
            float value = Float.valueOf(substring);
            if (solution.length() == 0) {
                helper(num, substring, operations, i + start, target, value, value, result);
            } else {

                for (int k = 0; k < operations.length; k++) {

                    if (operations[k] == "-") {
                        helper(num, solution + operations[k] + substring, operations, i + start, target, sum - value, -value, result);
                    } else if (operations[k] == "+") {
                        helper(num, solution + operations[k] + substring, operations, i + start, target, sum + value, value, result);
                    } else {
                        helper(num, solution + operations[k] + substring, operations, i + start, target, sum - previous + value * previous, value*previous, result);
                    }

                }
            }

        }
    }
}


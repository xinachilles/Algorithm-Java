import java.util.Stack;

/**
 * Created by xhu on 11/27/16.
 */
public class BasicCalculatorII {
   /* public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char op = '+';
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (Character.isDigit(current)) {
                result = result * 10 + Character.getNumericValue(current);

            }
            if((!Character.isDigit(s.charAt(i)) &&' '!=s.charAt(i)) || i==s.length()-1){

                if (op == '+') {
                    stack.push(result);

                } else if (op == '-') {
                    stack.push(-1 * result);

                } else if (op == '*') {
                    stack.push(stack.pop() * result);

                } else if (op == '/') {
                    stack.push(stack.pop() / result);
                }

                result = 0;
                op = current;
            }
        }

            while (!stack.isEmpty()) {
                result = result + stack.pop();
            }

            return result;

        }
    }*/

    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        return solveRPN(getRPN(s));
    }

    private String getRPN(String s) {
        if (s == null) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        Stack<Character> op = new Stack<>();

        for (Character c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                result.append(c);
            } else {
                result.append(' ');

                if (c == ')') {
                    while (!op.isEmpty() && op.peek() != '(') {
                        result.append(op.pop());
                        result.append(' ');
                    }

                    if (!op.isEmpty() && op.peek() == '(') {
                        op.pop();

                    }

                    continue;

                } else if ("+-*/".indexOf(c) >= 0) {
                    while (!op.isEmpty() && getWeight(op.peek()) >= getWeight(c)) {
                        result.append(op.pop());
                        result.append(' ');
                    }
                }

                op.push(c);
            }
        }

        while (!op.isEmpty()) {
            result.append(' ');
            result.append(op.pop());

        }

        return result.toString();
    }

    private int solveRPN(String s) {
        if (s == null) {
            return 0;
        }


        String[] str = s.split(" ");
        Stack<Integer> stack = new Stack<>();

        for (String s1 : str) {
            if(s1.trim().length() ==0){
                continue;
            }
            if("+-*/".indexOf(s1) != -1){
                int number1 = stack.pop();
                int number2 = stack.pop();
                int result = 0;

                if (s1.equals("+")) {
                    result = number1 + number2;
                } else if (s1.equals("-")) {
                    result = number2-number1;
                } else if (s1.equals("*")) {
                    result = number1 * number2;
                } else if (s1.equals("/")) {
                    result = number2 / number1;
                }

                stack.push(result);
            }else{
                stack.push(Integer.valueOf(s1));
            }
        }

        return stack.pop();
    }

    private int getWeight(Character c) {
        if ("+-".indexOf(c) >=0) {
            return 1;
        }

        if ("*/".indexOf(c) >=0) {
            return 2;
        }

        return 0;
    }
}


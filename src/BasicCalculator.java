import java.util.*;

public class BasicCalculator {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        return solveRPN(getRPN(s));
    }

    private List<String> getRPN(String s) {
        if (s == null) {
            return null;
        }

        List<String> result = new ArrayList<>();
        Stack<Character> op = new Stack<>();
        int i = 0;
        while (i < s.length()) {

            if (s.charAt(i) == ' ') {
                continue;
            }
            String number = "";
            if(Character.isDigit(s.charAt(i))) {
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    number += s.charAt(i);
                    i++;
                }
                result.add(number);
            }else {

                if (s.charAt(i) == ')') {
                    while (!op.isEmpty() && op.peek() != '(') {
                        result.add(op.pop().toString());
                    }

                    if (!op.isEmpty() && op.peek() == '(') {
                        op.pop();

                    }


                } else if ("+-*/".indexOf(s.charAt(i)) >= 0) {
                    while (!op.isEmpty() && getWeight(op.peek()) >= getWeight(s.charAt(i))) {
                        result.add(op.pop().toString());

                    }
                }
                op.push(s.charAt(i));
                i++;
            }
        }

        while (!op.isEmpty()) {

            result.add(op.pop().toString());

        }

        return result;
    }

    private int solveRPN(List<String> s) {
        if (s == null) {
            return 0;
        }


        Stack<Integer> stack = new Stack<>();

        for (String s1 : s) {
            if (s1.trim().length() == 0) {
                continue;
            }
            if ("+-*/".indexOf(s1) != -1) {
                int number1 = stack.pop();
                int number2 = stack.pop();
                int result = 0;

                if (s1.equals("+")) {
                    result = number1 + number2;
                } else if (s1.equals("-")) {
                    result = number2 - number1;
                } else if (s1.equals("*")) {
                    result = number1 * number2;
                } else if (s1.equals("/")) {
                    result = number2 / number1;
                }

                stack.push(result);
            } else {
                stack.push(Integer.valueOf(s1));
            }
        }

        return stack.pop();
    }

    private int getWeight(Character c) {
        if ("+-".indexOf(c) >= 0) {
            return 1;
        }

        if ("*/".indexOf(c) >= 0) {
            return 2;
        }

        return 0;
    }
}
package Indeed;

import java.util.Stack;

public class Calcuator {
    // Pt.1 Calculator without parenthesis, only +, -, non-negative ints
    public static int basicCalculator1(String expression) {
        if (expression == null || expression.length() == 0) {
            return 0;
        }
        int result = 0;

        int sign = 1;
        for (int i = 0; i < expression.length(); i++) {

            if (Character.isDigit(expression.charAt(i))) {
                int number = 0;
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    number = number * 10 + (int) expression.charAt(i) - '0';
                    i++;
                }
                result += sign * number;
                i--;
            } else if (expression.charAt(i) == '+') {
                sign = 1;

            } else if (expression.charAt(i) == '-') {
                sign = -1;

            }
        }

        return result;
    }

    //加上parenthesis， 例如"2+((8+2)+(3-999))"，返回计算结果。
    public static int basicCalculator2(String expression) {
        if (expression == null || expression.length() == 0) {
            return 0;
        }
        int result = 0;

        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            if (Character.isDigit(expression.charAt(i))) {
                int number = 0;
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    number = number * 10 + (int) expression.charAt(i) - '0';
                    i++;
                }
                result += sign * number;
                i--;
            } else if (expression.charAt(i) == '+') {
                sign = 1;

            } else if (expression.charAt(i) == '-') {
                sign = -1;

            } else if (expression.charAt(i) == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;

            } else if (expression.charAt(i) == ')') {
                result = result * stack.pop() + stack.pop();

            }
        }
        return result;

    }

    public static void main(String[] args) {
        int result = basicCalculator2("3+(5-5)" );
        System.out.println(result);
    }
}

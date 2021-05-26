package Indeed;

import java.util.HashMap;
import java.util.Map;
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
                //result * sign+result
                result = result * stack.pop() + stack.pop();

            }
        }
        return result;

    }
   public static int basicCalculator3(String expression, Map<String,Integer> maps){
        for(String key: maps.keySet()){
            if(expression.indexOf(key)>=0){
                expression.replaceAll(key,String.valueOf(maps.get(key)));
            }
        }
        return basicCalculator2(expression);
   }
    public static void main(String[] args) {
        int result = basicCalculator2("3+(1-1)" );
        Map<String,Integer> maps = new HashMap<>();
        maps.put("banana", 4);
        maps.put("apple", 9);
        //result = basicCalculator3()
        System.out.println(result);
    }
}

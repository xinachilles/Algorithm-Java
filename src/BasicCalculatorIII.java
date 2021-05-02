import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BasicCalculatorIII {
    public int calculate(String s) {
        if( s== null || s.length() == 0){
            return 0;
        }

        return solveRPN(getRPN(s));
    }
    private List<String> getRPN(String s){

        Stack<Character> operations = new Stack<>();
        List<String> result  = new ArrayList<>();


        for(int i =0; i<s.length();i++){
            char c = s.charAt(i);
            if( c == ' '){
                continue;
            }else if( i == 0 && c == '-'){
                operations.push('*');
                result.add("-1");
            }
            else if(Character.isDigit(c)){
                int number = 0;
                int j = i;
                while(j<s.length() && Character.isDigit(s.charAt(j))){
                    number  = number *10+ (s.charAt(j) -'0');
                    j++;
                }

                i = j-1;
                result.add(String.valueOf(number));

            }else{
                if(c == '('){
                    operations.push(c);
                    // this is to deal with 1 * (-7+2) case
                    if (isNegativeNumberFollowingLeftBracket(s, i + 1)) {
                        result.add("-1");
                        operations.push('*');
                        while (i < s.length()) {
                            if (s.charAt(i) == '-') {
                                // i++;  // skip this '-', later we i++ on line 129
                                break;
                            }

                        }
                    }
                }else if( c == ')'){
                    while(!operations.isEmpty() && operations.peek() != '('){

                        result.add(String.valueOf(operations.pop()));
                    }
                    // pop the left p
                    operations.pop();

                }else if( "+-/*".indexOf(c)>=0) {
                    while(!operations.isEmpty() && Weight(operations.peek())>Weight(c)){

                        result.add(String.valueOf(operations.pop()));
                    }
                    operations.push(c);

                }
            }
        }

        while(!operations.isEmpty()){

            result.add(String.valueOf(operations.pop()));
        }

        return result;
    }
    private int Weight(Character c){
        if("+-".indexOf(c)>=0){
            return 1;
        }else if("*/".indexOf(c)>=0){
            return 2;
        }else{
            return 0;
        }
    }
    private boolean isNegativeNumberFollowingLeftBracket(String s, int index) {
        while (index < s.length()) {
            char c = s.charAt(index);
            if (c == ' ') {
                index++;
                continue;
            }
            if (c == '-') {
                return this.isDigitFollowing(s, index + 1);
            } else {
                return false;
            }
        }
        return false;
    }
    private boolean isDigitFollowing(String s, int index) {
        while (index < s.length()) {
            char c = s.charAt(index);
            if (c == ' ') {
                index++;
                continue;
            }
            if (Character.isDigit(c)) {
                return true;
            }
            return false;
        }
        return false;
    }
    private int solveRPN(List<String> s) {
        if (s == null) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        for (String s1 : s) {
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
}

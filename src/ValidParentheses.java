import java.util.Stack;

/**
 * Created by xhu on 10/8/16.
 */
public class ValidParentheses {
    // valid parentheses
    public boolean isValid(String s){
        if(s == null || s.length() == 0){
            return true;
        }

        Stack<Character> stack = new Stack<Character>();

        for(Character c : s.toCharArray()){
            if(c == ')'){
                if (!stack.isEmpty() && stack.peek() =='('){
                    stack.pop();
                }else{
                    return false;
                }
            }else if(c == '}'){
                if (!stack.isEmpty() && stack.peek() =='{'){
                    stack.pop();
                }else{
                    return false;
                }
            }else if(c == ']'){
                if (!stack.isEmpty() && stack.peek() =='['){
                    stack.pop();
                }else{
                    return false;
                }
            }else{
                stack.push(c);
            }
        }

        return stack.size() ==0;
    }
//

}

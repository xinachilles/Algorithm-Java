package AmazonOA;

import java.util.*;

/**
 * Created by xhu on 4/15/17.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
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
}

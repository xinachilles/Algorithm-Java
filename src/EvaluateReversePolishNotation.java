import com.sun.deploy.util.StringUtils;

import java.util.Stack;

/**
 * Created by xhu on 3/4/17.
 */
public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {

        if(tokens == null || tokens.length ==0){
            return 0;
        }

        Stack<Integer> s = new Stack<>();
        for(String t:tokens){
            if("+-*/".indexOf(t) == -1){
                s.push(Integer.valueOf(t));
            }else{
                if(s.size()<2){
                    return -1;
                }

                int num1 = s.pop();
                int num2 = s.pop();

                if(t.equals("+")) s.push(num1 + num2);
                if(t.equals("-")) s.push(num1 - num2);
                if(t.equals("*")) s.push(num1 * num2);
                if(t.equals("/")) s.push(num1 / num2);
            }
        }

        if(s.isEmpty() || s.size()>1){
            return -1;
        }
        return s.pop();
    }
}

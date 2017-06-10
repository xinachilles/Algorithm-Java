import java.util.Stack;

/**
 * Created by xhu on 5/19/17.
 */
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if(num == null || num.length() == 0){
            return "0";
        }


        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i<num.length();i++){
            int current = num.charAt(i) - '0';

            while(!stack.isEmpty() && stack.peek()>current && k>0){
                stack.pop();
                k--;
            }

            stack.push(current);
        }

        while(k>0 && !stack.isEmpty()){
            stack.pop();
            k--;
        }

        String result = "";
        while(!stack.isEmpty()){
            result = String.valueOf(stack.pop())+result;
        }

        int i = 0;
        for(; i<result.length(); i++){
            if(result.charAt(i) != '0'){
                break;
            }
        }

        return result.trim().length() == 0 ? "0": result.substring(i,result.length());
    }
}

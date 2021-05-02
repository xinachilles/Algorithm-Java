import java.util.Stack;

/**
 * Created by xhu on 5/19/17.
 */
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if(num == null || num.length() == 0){
            return num;
        }

        // keep a stack and the number in the stack is sorted by descending order
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for(; i<num.length() && k>0; i++){
            int n = num.charAt(i) - '0';
            while(!stack.isEmpty() && stack.peek()>=n){
                stack.pop();
                k--;
            }
        }

        while(k>0 && !stack.isEmpty()){
            stack.pop();
            k--;
        }

        String result = "";
        while(!stack.isEmpty()){
            result =  String.valueOf(stack.pop())+result;
        }

        int j = 0;
        while(j<result.length()){
            if(result.charAt(j)!='0'){
                break;
            }

            j++;
        }

        return result.substring(j,result.length())+num.substring(i,num.length());
    }
}

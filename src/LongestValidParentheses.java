import java.util.Stack;

/**
 * Created by xhu on 10/6/16.
 */

public class LongestValidParentheses {
    /*public int longestValidParentheses(String s){
        if(s ==null || s.length() ==0 ){
            return  0;
        }
        Stack<Character> parentheses = new Stack<>();
        int count  = 0;
        int max = Integer.MIN_VALUE;

        for(char c: s.toCharArray()){
            if(c == '('){
                parentheses.push(c);
            }else{

                if(parentheses.size()>0 && parentheses.peek() == '('){
                    parentheses.pop();
                    count =count+2;
                    max = Math.max(count,max);
                }else{
                    count = 0;
                }
            }
        }
                return count;
    }*/

    // longest valid parentheses
   /* public int longestValidParentheses(String s){
        if(s == null || s.length() == 0){
            return 0;
        }

        Stack<Integer> index = new Stack<>();
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == ')' && !index.isEmpty() && s.charAt(index.peek()) == '('){
                    index.pop();

            }else{
                index.push(i);
            }
        }

        if(index.isEmpty()){
            return s.length();
        }else{
            int max = 0;
            int first = s.length()-1;
            int last = s.length();
            while(!index.isEmpty()){
                first = index.pop();
                max= Math.max(last- first-1,max);

                last = first;
            }

            max = Math.max(max,first);
            return max;
        }
    }*/

    // longest valid parentheses dymatic
    public int longestValidParentheses(String s){
        if( s == null || s.length() ==0){
            return 0;
        }

        int[] longest = new int[s.length()];
        // the longest parentheses for s(0...i);
        int max = Integer.MIN_VALUE;

        for(int i =0; i<s.length(); i++){
            if(i>0 && s.charAt(i) ==')' && s.charAt(i-1) == '('){
                longest[i] = 2+longest[i];
                if(i>1){
                    longest[i]  = longest[i] + longest[i-2];
                }


            }
        }

        return longest[s.length()-1];
    }
}

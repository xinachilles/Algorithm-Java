import java.util.Stack;
import javafx.util.Pair;

public class RemoveAllAdjacentDuplicatesString {
    public String removeDuplicates(String s, int k) {
       Stack<Pair<Character, Integer>> stack = new Stack<>();
       for(char c : s.toCharArray()){
           if(!stack.isEmpty()&& (stack.peek().getKey() == c)){
              if( stack.peek().getValue()+1 == k) {
                  while (!stack.isEmpty() && stack.peek().getKey() == c) {
                      stack.pop();
                  }
              }else{
                  stack.push(new Pair<>(c,stack.peek().getValue()+1));
              }
           }else{
               stack.push(new Pair<>(c,1));

           }
       }
       String result = "";
       while(!stack.isEmpty()){
           result= stack.pop().getKey()+result;
       }

       return  result;
    }
}

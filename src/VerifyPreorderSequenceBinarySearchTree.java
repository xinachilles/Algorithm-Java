import java.util.Stack;

/**
 * Created by xhu on 1/30/17.
 */
public class VerifyPreorderSequenceBinarySearchTree {
    public boolean verifyPreorder(int[] preorder) {
        if(preorder == null || preorder.length == 0){
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        Integer low = Integer.MIN_VALUE;
        for(int p : preorder){
            if(p<=low){
                return false;
            }

            while(!stack.isEmpty() && p>stack.peek()){
                low = stack.pop();
            }

            stack.push(p);
        }

        return true;
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextGreaterNodeLinkedList {
    public int[] nextLargerNodes(ListNode head) {
        if(head == null){
            return new int[]{};
        }

        List<Integer> nums = new ArrayList<>();
        ListNode current = head;
        while(current !=null){
            nums.add(current.val);
            current = current.next;
        }

        int[] result= new int[nums.size()];
        // store the index
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i<nums.size(); i++){
            while(!stack.isEmpty() && nums.get(stack.peek())<nums.get(i)){
                int index = stack.pop();
                result[index] = nums.get(i);
            }

            stack.push(i);
        }

        return result;

    }
}

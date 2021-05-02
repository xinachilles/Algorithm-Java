import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null){
            return null;
        }
        // stack is descond order
        Stack<Integer> stack  = new Stack<>();
        Map<Integer,Integer> maps = new HashMap<>();
        // key is the number in nums2, value is the is its next greater number to its right is nums2
        for(int n : nums2){
            while(!stack.isEmpty() && stack.peek()<n){
                int key = stack.pop();

                maps.put(key,n);
            }
            stack.push(n);
        }

        int[] result = new int[nums1.length];
        for(int i = 0; i<nums1.length;i++){
            result[i] = maps.getOrDefault(nums1[i],-1);
        }

        return result;
    }
}

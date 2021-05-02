import java.util.Stack;

public class Find132 {
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int[] min = new int[nums.length];// the min[i]: the min number from 0 to i;
        Stack<Integer> stack = new Stack<>();
        min[0] = nums[0];
        // 132 partten min[i] should be the "1"
        for (int i = 1; i < nums.length; i++) {
            min[i] = Math.min(nums[i], min[i - 1]);
        }

        //assume j is the "3"
        for (int j = nums.length - 1; j >= 1; j--) {
            if (nums[j] > min[j]) {
                // find the number "2" which is > min[j] and this number should be after the j
                while (!stack.isEmpty() && stack.peek() <= min[j]) {
                    stack.pop();
                }
                if (stack.isEmpty() && stack.peek() < nums[j]) {
                    return true;
                }
                stack.push(nums[j]);
            }
        }

        return false;
    }
}

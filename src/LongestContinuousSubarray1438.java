import java.util.ArrayDeque;
import java.util.Deque;

public class LongestContinuousSubarray1438 {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> max = new ArrayDeque<>();
        Deque<Integer> min = new ArrayDeque<>();
        int result = 0;
        int left = 0;

        for(int right =0; right<nums.length;right++){
            while (!max.isEmpty() && nums[right] > nums[max.getLast()]){
                max.removeLast();
            }
            max.addLast(right);

            while (!min.isEmpty() && nums[right]<nums[min.getLast()]){
                min.removeLast();
            }
            min.addLast(right);

            while (nums[max.peek()] - nums[min.peek()] > limit) {
                if (max.getFirst() == left) max.removeFirst();
                if (min.getFirst() == left) min.removeFirst();
                ++left;
            }

            result = Math.max(right-left+1,result);
        }

        return result;

    }
}

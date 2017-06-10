import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by xhu on 3/20/17.
 */
public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        Deque<Integer> deque = new ArrayDeque<Integer>();
        int[] result = new int[nums.length];
        int index = 0;
        // store the index
        for (int i = 0; i < nums.length; i++) {
            // if the number is out of range, remove it
            if (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                deque.removeLast();
            }

            deque.offer(i);

            if (i >= k - 1) {
                result[index++] = nums[deque.peek()];
            }
        }

        return result;
    }

    }


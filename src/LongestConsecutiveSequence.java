import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by xhu on 10/26/16.
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> sets = new HashSet<>();
        int max = 0;
        for (int n : nums) {
            sets.add(n);
        }


        for (int n : nums) {
            int count = 0;
            int left = n - 1;
            int right = n + 1;

            while (!sets.isEmpty() && sets.contains(left)) {
                sets.remove(left);
                count++;
                left--;
            }

            while (!sets.isEmpty() && sets.contains(right)) {
                sets.remove(right);
                count++;
                right++;
            }

            max = Math.max(max, count);
        }

        return max;
    }
}

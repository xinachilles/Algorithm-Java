import java.util.HashSet;
import java.util.Set;

/**
 * Created by xhu on 9/15/16.
 */
public class ContainsDuplicateIII {
   /*
    public boolean containsNerbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0) {
            return true;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= i + k && j < nums.length; j++) {
                if (Math.abs((long)nums[i] - nums[j]) <= t) {
                    return true;
                }
            }
        }

        return false;
    }
    */

    public boolean containsNerbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        Set<Integer> maps = new HashSet<Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                maps.remove(nums[i - k - 1]);
            }

            if (maps.contains(nums[i])) {
                return true;
            }

            maps.add(nums[i]);

        }

        return false;
    }
}

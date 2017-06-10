import java.util.HashMap;
import java.util.Map;

/**
 * Created by xhu on 9/13/16.
 */
public class MaximumSizeSubarraySumEqualsk {

    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> maps = new HashMap<Integer, Integer>();
        int sum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = nums[i] + sum;
            if (sum == k) {
                max = i+1;
            } else {
                if (maps.containsKey(sum - k)) {
                    max = Math.max(max, i - maps.get(sum - k));
                }
            }
            if(!maps.containsKey(sum)){
                maps.put(sum, i);
            }

        }

        return max;
    }
}

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by xhu on 10/29/16.
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int start = i + 1;
            int end = nums.length - 1;


            while (start < end) {
                int sum = current + nums[start] + nums[end];
                if (sum == target) {
                    return target;
                }
                if (min > Math.abs(sum - target)) {
                    min = Math.abs(sum - target);
                    result = sum;
                }
                if (sum < target) {
                    start++;
                } else {
                    end--;
                }


            }
        }

        return result;
    }
}

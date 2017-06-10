import java.util.Arrays;

/**
 * Created by xhu on 11/6/16.
 */
public class ThreeSumSmaller {
    // 3 sum smaller
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;

        }
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i <= nums.length - 3; i++) {
            if (i >= 1 && nums[i + 1] == nums[i]) {
                continue;
            }

            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum < target) {
                    count = count + end- start;
                    start++;
                } else {
                    end--;
                }
            }
        }

        return count;
    }


}

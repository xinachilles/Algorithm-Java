import java.util.Arrays;

/**
 * Created by xhu on 11/21/16.
 */
public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }


        return Math.max(rob2(Arrays.copyOfRange(nums, 0, nums.length - 1)), rob2(Arrays.copyOfRange(nums, 1, nums.length )));


    }

    private int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] max = new int[nums.length];
        // max[i] is the max value the robber can rob from 0 to i house

        max[0] = nums[0];

        if (nums.length > 1) {
            max[1] = Math.max(nums[0], nums[1]);
        }
        for (int i = 2; i < nums.length; i++) {
            max[i] = Math.max(max[i - 1], max[i - 2] + nums[i]);
        }

        return max[nums.length - 1];
    }
}

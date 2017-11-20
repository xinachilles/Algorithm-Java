/**
 * Created by xhu on 7/9/17.
 */
public class TargetSum {
    int count = 0;

    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        helper(nums, 0, 0, S, 0);
        return count;

    }

    private void helper(int[] nums, int index, int sum, int target, int current) {

        if (index == nums.length) {

            if (sum == target && current == 0) {

                count++;
            }

            return;
        }


        helper(nums, index + 1, sum + nums[index], target, current + 1);
        helper(nums, index + 1, sum - nums[index], target, current + 1);

    }
}

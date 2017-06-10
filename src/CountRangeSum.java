/**
 * Created by xhu on 9/16/16.
 */
public class CountRangeSum {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum = sum + nums[j];

                if (sum >= lower && sum <= upper) {
                    count++;
                }

            }
        }

        return count;
    }
}

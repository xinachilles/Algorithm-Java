/**
 * Created by xhu on 10/23/16.
 */
public class MaxProduct {
    public int maxProducts(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = 1;
        int min = 1;
        int result = 0;

        for (int n : nums) {
            int temp = max;

            max = Math.max(Math.max(n, n * max), n * min);
            min = Math.min(Math.min(n, n * temp), n * min);

            result = Math.max(result, max);

        }

        return result;

    }
}

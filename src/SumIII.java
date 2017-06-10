import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xhu on 10/20/16.
 */
public class SumIII {
    // 3 sum
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i <= nums.length - 3; i++) {
            int current = nums[i];
            List<Integer> solution = new ArrayList<>();
            int start = i+1;
            int end = nums.length - 1;

            while (start < end) {
                if (nums[start] + nums[end] + current == 0) {
                    solution.add(current);
                    solution.add(nums[start]);
                    solution.add(nums[end]);
                    start++;
                    end--;

                } else if (nums[start] + nums[end] + current < 0) {
                    start++;
                } else {
                    end--;
                }

            }
            if (solution.size() > 0 && !result.contains(solution)) {

                result.add(solution);
            }
        }

        return result;
    }
}

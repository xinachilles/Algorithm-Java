import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xhu on 10/29/16.
 */
public class ThreeSum {
    public List<List<Integer>> ThreeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i <= nums.length - 3; i++) {
            if (i > 1 && nums[i] == nums[i - 1]) {
                continue;
            }

            int start = i + 1;
            int end = nums.length - 1;


            while (start < end) {
                List<Integer> solution = new ArrayList<>();


                if (nums[start] + nums[end] + nums[i] == 0) {
                    solution.add(nums[i]);
                    solution.add(nums[start]);
                    solution.add(nums[end]);
                    while (start < end && nums[start] == nums[start + 1]) {
                        start++;
                    }

                    while (start < end && nums[end] == nums[end - 1]) {
                        end--;
                    }
                    start++;
                    end--;
                } else if (nums[start] + nums[end] + nums[i] < 0) {
                    start++;
                } else {
                    end--;
                }

                result.add(solution);
            }
        }

        return result;
    }

}

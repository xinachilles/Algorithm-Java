import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 10/30/16.
 */
public class MissRange {
    //missing ranges

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return result;
        }

        if (lower < nums[0]) {
            result.add(BuildRange(lower, nums[0] - 1));
        }


        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] != nums[i] + 1) {
                result.add(BuildRange(nums[i] + 1, nums[i + 1] - 1));
            }
        }

        if (nums[nums.length - 1] < upper) {
            result.add(BuildRange(nums[nums.length - 1] + 1, upper));
        }

        return result;
    }

    private String BuildRange(int start, int end) {
        StringBuilder solution = new StringBuilder();
        if (start == end) {
            solution.append(start);
        } else {
            solution.append(start);
            solution.append("->");
            solution.append(end);

        }

        return solution.toString();
    }

}

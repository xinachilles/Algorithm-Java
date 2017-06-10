import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 11/4/16.
 */
public class permutation {
    //permutation
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return result;
        }

        permuteHelper(nums, 0, result, new ArrayList<>());
        return result;
    }

    private void permuteHelper(int[] nums, int index, List<List<Integer>> result, List<Integer> solution) {
        if (solution.size() == nums.length) {
            result.add(new ArrayList<Integer>(solution));
            return;
        }

        if (index == nums.length) {
            index = 0;
        }

        for (int i = 0; i < nums.length; i++) {
            if (solution.contains(nums[i])) {
                continue;
            }

            solution.add(nums[i]);
            permuteHelper(nums, index + 1, result, solution);
            solution.remove(solution.size() - 1);
        }
    }
}

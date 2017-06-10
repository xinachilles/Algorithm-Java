import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xhu on 11/5/16.
 */
public class PermutationII {

    // permutations ii
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);
        List<Integer> solution = new ArrayList<>();
        int[] visited = new int[nums.length];

        permuteUniqueHelper(nums, result, solution, visited);
        return result;
    }

    private void permuteUniqueHelper(int[] nums, List<List<Integer>> result, List<Integer> solution, int[] visted) {
        if (solution.size() == nums.length) {
            result.add(new ArrayList<>(solution));
            return;
        }
        int lastValue = Integer.MAX_VALUE;


        for (int i = 0; i < nums.length; i++) {
            if (lastValue != nums[i] && visted[i] == 0) {
                solution.add(nums[i]);
                visted[i] = 1;
                permuteUniqueHelper(nums, result, solution, visted);

                solution.remove(solution.size() - 1);
                lastValue = nums[i];
                visted[i] = 0;

            }
        }
    }


}

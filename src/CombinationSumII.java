import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xhu on 11/5/16.
 */
public class CombinationSumII {
    // combination sum ii

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if (candidates == null || candidates.length == 0) {
            return result;

        }

        Arrays.sort(candidates);
        List<Integer> solution = new ArrayList<>();

        combinationSum2Helper(candidates, target, 0, 0, solution, result);
        return result;
    }

    private void combinationSum2Helper(int[] candidates, int target, int index, int sum, List<Integer> solution, List<List<Integer>> result) {
        if (sum > target || index >= candidates.length) {
            return;
        }

        if (sum == target) {
            result.add(new ArrayList<Integer>(solution));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i != index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if (sum + candidates[i] > target) {
                return;
            }

            solution.add(candidates[i]);
            combinationSum2Helper(candidates, target, i + 1, sum + candidates[i], solution, result);
            solution.remove(solution.size() - 1);
        }
    }

}


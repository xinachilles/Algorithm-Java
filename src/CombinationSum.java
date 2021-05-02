import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xhu on 10/29/16.
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> solution = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSumHelper(candidates, target, result, solution, 0, 0);
        return result;
    }

    private void combinationSumHelper(int[] candidates, int target, List<List<Integer>> result, List<Integer> solution, int sum, int index) {
        if (index >= candidates.length) {
            return;

        }

        if (sum == target) {
            if (solution.size() > 0) {
                result.add(new ArrayList<>(solution));
            }
            return;
        }


        if (sum + candidates[index] <= target ) {
            solution.add(candidates[index]);
            combinationSumHelper(candidates, target, result, solution, sum + candidates[index], index + 1);
            solution.remove(solution.size() - 1);

        }
        while (index+1<candidates.length && candidates[index] == candidates[index+1]){
            index++;
        }
        combinationSumHelper(candidates, target, result, solution, sum, index + 1);

    }


}

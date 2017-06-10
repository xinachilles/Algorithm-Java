import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xhu on 10/29/16.
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> solution = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSumHelper(candidates, target, result, solution, 0,0);
        return result;
    }

    private void combinationSumHelper(int[] candidates, int target, List<List<Integer>> result, List<Integer> solution, int sum,int index) {
        if (sum > target || index>=candidates.length) {
            return;

        }


        if (sum == target) {
            if (solution.size() > 0) {
                result.add(new ArrayList<>(solution));
            }
            return;
        }

        for (int i = index; i < candidates.length; i++) {

            solution.add(candidates[i]);
            combinationSumHelper(candidates, target, result, solution, sum + candidates[i],i+1);
            solution.remove(solution.size() - 1);
        }
    }

}

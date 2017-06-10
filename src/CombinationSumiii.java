import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 10/30/16.
 */
public class CombinationSumiii {
    //combination sum iii
    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> result = new ArrayList<>();
        if (k <= 0 || n <= 0) {
            return result;
        }

        List<Integer> solution = new ArrayList<>();
        combinationSum3Helper(k, n, 1, result, solution, 0);
        return result;
    }

    private void combinationSum3Helper(int k, int n, int index, List<List<Integer>> result, List<Integer> solution, int sum) {
        if (solution.size() > k || sum > n) {
            return;
        }

        if (sum == n) {
            if (solution.size() == k) {
                result.add(new ArrayList<>(solution));

            }

            return;
        }

        for (int i = index; i <= 9; i++) {
            solution.add(i);
            combinationSum3Helper(k, n, i + 1, result, solution, sum + i);
            solution.remove(solution.size()-1);

        }
    }
}

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 11/5/16.
 */
public class Combination {
    // combinations
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n == 0 || k == 0) {
            return result;
        }


        combineHelper(n, k, 0, result, new ArrayList<>());
        return result;
    }

    private void combineHelper(int n, int k, int index, List<List<Integer>> result, List<Integer> solution) {
        //first time : index>= n
        // no need
        if (index > n) {
            return;
        }


        if (solution.size() == k) {
            result.add(new ArrayList<Integer>(solution));
            return;
        }

        for (int i = index; i <= n; i++) {
            solution.add(i);
            combineHelper(n, k, i + 1, result, solution);

            solution.remove(solution.size() - 1);

        }
    }
}

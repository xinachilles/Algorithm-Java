import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by xhu on 11/6/16.
 */
public class FactorCombinations {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> getFactors(int n) {
        if (n <= 0) {
            return result;
        }
        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                factors.add(i);
            }
        }

        helper(n, factors, new ArrayList<>(), 2);

        return result;
    }

    private void helper(int n, List<Integer> factors, List<Integer> solution, int index) {


        if (n == 1) {
            if (solution.size() > 1) {
                result.add(new ArrayList<>(solution));
            }

            return;
        }

        for (int i = 0; Math.pow(factors.get(index), i) <= n; i++) {
            if (i == 0 || n % Math.pow(factors.get(index), i) == 0) {
                for (int j = 0; j < i; j++) {
                    solution.add(factors.get(factors.get(index)));
                }
                helper((int) (n / Math.pow(factors.get(index), i)), factors, solution, index + 1);

                for (int j = 0; j < i; j++) {
                    solution.remove(factors.get(index));
                }

            }


        }

    }


}



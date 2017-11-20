import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by xhu on 11/6/16.
 */
public class FactorCombinations {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        if(n<=0){
            return result;
        }

        getFactorsHelper(n, result, new ArrayList<>(),2);

        return result;
    }

    private void getFactorsHelper(int n, List<List<Integer>> result, List<Integer> solution, int start) {


        if (n==1) {
            if(solution.size()>1){
                result.add(new ArrayList<>(solution));
            }

            return;
        }


        for (int i = start; i <= n; i++) {
            if (n % i == 0) {
                solution.add(i);
                getFactorsHelper(n/i, result, solution,i);
                solution.remove(solution.size() - 1);
            }
        }

    }


}



import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 10/29/16.
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        List<List<Integer>> result = new ArrayList<>();
        subsetsHelper(nums, new ArrayList<Integer>(), result,0);
        return result;


    }

    private void subsetsHelper(int[] nums, List<Integer> solution, List<List<Integer>> result,int index ) {
        result.add(new ArrayList<Integer>(solution));
        for (int i = index; i < nums.length; i++) {
            solution.add(i);
            subsetsHelper(nums, solution, result,i+1);
            solution.remove(solution.size() - 1);
        }


    }

}

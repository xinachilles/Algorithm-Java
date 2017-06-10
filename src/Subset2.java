import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xhu on 10/30/16.
 */
public class Subset2 {
    //subset2
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        subsets2Helper(result, 0, nums, new ArrayList<>());
        return result;

    }


    private void subsets2Helper(List<List<Integer>> result, int index, int[] nums, List<Integer> solution) {

        result.add(new ArrayList<>(solution));
        for (int i = index; i < nums.length; i++) {

            solution.add(nums[i]);
            subsets2Helper(result, i + 1, nums, solution);
            solution.remove(solution.size() - 1);
            while(i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
        }


    }


}

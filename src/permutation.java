import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by xhu on 11/4/16.
 */
public class permutation {
    //permutation
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return result;
        }

        Queue<List<Integer>> queue = new LinkedList<>();
        for(int n : nums){
            int size = queue.size();
            for(int i = 0; i<size;i++){
                List<Integer> l = queue.poll();
                for(int j = 0; j<=l.size();j++){
                    List<Integer> temp = new ArrayList<>(l);
                    temp.add(j,0);
                    queue.offer(temp);
                }
            }
        }


        while (!queue.isEmpty()){
            result.add(queue.poll());
        }

        return result;
    }

    private void permuteHelper(int[] nums, int index, List<List<Integer>> result, List<Integer> solution) {
        if (solution.size() == nums.length) {
            result.add(new ArrayList<Integer>(solution));
            return;
        }

        if (index == nums.length) {
            index = 0;
        }

        for (int i = 0; i < nums.length; i++) {
            if (solution.contains(nums[i])) {
                continue;
            }

            solution.add(nums[i]);
            permuteHelper(nums, index + 1, result, solution);
            solution.remove(solution.size() - 1);
        }
    }
}

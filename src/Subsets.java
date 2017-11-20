import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by xhu on 10/29/16.
 */
public class Subsets {
   /* public List<List<Integer>> subsets(int[] nums) {
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


    }*/

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if(nums == null || nums.length == 0){
            return result;
        }

        Queue<List<Integer>> visited = new LinkedList<>();
        visited.offer(new ArrayList<Integer>());

        for(int i = 0; i<nums.length;i++){
            int number  = nums[i];
            int size = visited.size();
            for(int k = 0; k<size;k++){
                List<Integer> temp = visited.poll();
                result.add(new ArrayList<Integer>(temp));
                temp.add(number);
                visited.offer(temp);
            }
        }


        return result;
    }

}

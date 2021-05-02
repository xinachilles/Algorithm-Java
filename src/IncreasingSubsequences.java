import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IncreasingSubsequences {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        if(nums == null || nums.length ==0){
            return result;
        }

        helper(nums,new ArrayList<>(),0);
        return result;
    }

    private void helper(int[]nums, List<Integer> solution,int index){

        if(index == nums.length){
            if(solution.size() >=2){
                result.add(new ArrayList<>(solution));
            }
            return;
        }

        Set<Integer> used = new HashSet<>();
        if(!used.contains(nums[index]) && nums[index]>=solution.get(solution.size()-1)){
                solution.add(nums[index]);
                used.add(nums[index]);
                helper(nums,solution,index+1);
                solution.remove(solution.size()-1);
        }
        helper(nums,solution,index+1);
    }
}

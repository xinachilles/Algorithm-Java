import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by xhu on 11/5/16.
 */
public class PermutationII {

    // permutations ii
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        permuteUniqueHelper(nums, result,0);
        return result;
    }

    private void permuteUniqueHelper(int[] nums, List<List<Integer>> result,int level) {
        if (level == nums.length) {
            result.add(getList(nums));
            return;
        }

        HashSet<Integer> visited = new HashSet<>();

        for (int i = level ; i < nums.length; i++) {
           if(!visited.contains(nums[i])){
               Swap(nums,level, i);
               visited.add(nums[i]);
               permuteUniqueHelper(nums, result, level+1);
               Swap(nums,i,level);

           }


        }
    }

    private List<Integer> getList(int[] nums){
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i<nums.length;i++){
            result.add(nums[i]);
        }

        return result;
    }

    private void Swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}

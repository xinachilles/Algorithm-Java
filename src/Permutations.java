import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 7/4/17.
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result  = new ArrayList<>();

        if(nums == null || nums.length==0){
            return result;
        }

        result.add(new ArrayList<Integer>());

        for(int i =0; i<nums.length;i++){
            int number = nums[i];
            int size = result.size();
            List<List<Integer>> nextLevel  = new ArrayList<>();
            for(int k = 0;k<size;k++){
                List<Integer> pre = result.get(k);
                for(int j=0;j<=pre.size();j++){
                    List<Integer> current = new ArrayList<Integer>(pre);
                    current.add(j,number);
                    nextLevel.add(current);
                }
            }

            result = nextLevel;
        }

        return result;
    }
}

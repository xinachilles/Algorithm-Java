import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 4/3/17.
 */
public class FIndDuplicate {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return result;
        }

        for(int i = 0; i<nums.length; i++){
            while(nums[i] != i+1){
                if(nums[i] == nums[nums[i]-1]){
                    result.add(nums[i]);
                    break;
                }

                int a = nums[i];
                int b = nums[nums[i]-1];

                nums[i] = b;
                nums[a-1]  =a ;
            }
        }

        return result;
    }
}

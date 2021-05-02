import java.util.HashMap;
import java.util.Map;

/**
 * Created by xhu on 10/30/16.
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        HashMap<Integer,Integer> maps = new HashMap<>();
        maps.put(0,-1);
        int sum  = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<nums.length; i++){
            sum +=nums[i];
            if(maps.containsKey(sum)){
                min = Math.min(i-maps.get(sum),min);
            }

            maps.put(sum,i);
        }

        return min;
    }
}

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xhu on 10/30/16.
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length ==0){
            return 0;
        }

        int sum = 0;
        int min = Integer.MAX_VALUE;
        int right = 0;
        int left = 0;
        for(;right<nums.length;right++){
            sum = sum+nums[right];

            while(sum>=s){
                min = Math.min(min,right-left+1);
                sum = sum-nums[left];
                left++;
            }

        }
        return min == Integer.MAX_VALUE? 0: min;
    }
}

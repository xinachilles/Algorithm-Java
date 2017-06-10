import java.util.Arrays;

/**
 * Created by xhu on 11/17/16.
 */
public class combinationSum4 {
    int count =0;
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0)
        {
            return 0;
        }

        int[] sum = new int[target + 1];
        // sum[i] means the total number of combinatation which sum equal to i
        sum[0] = 1;


        for (int i = 1; i <= target; i++)
        {
            int count = 0;
            for(int j = 0; j<nums.length;j++){

                if(i-nums[j]>=0){
                    count = count + sum[i-nums[j]];
                }
            }
            sum[i] = count;
        }

        return sum[target];
    }


}

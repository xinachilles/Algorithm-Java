/**
 * Created by xhu on 11/21/16.
 */
public class HouseRobber {
    public int rob(int[] nums) {
        if(nums == null || nums.length ==0){
            return 0;
        }

        int[] max = new int[nums.length];
        // max[i] is the max value the robber can rob from 0 to i house

        max[0] = nums[0];

        if(nums.length >1) {
            max[1] = Math.max(nums[0], nums[1]);
        }
        for(int i =2; i<nums.length;i++){
            max[i] = Math.max(max[i-1], max[i-2]+nums[i]);
        }

        return max[nums.length-1];
    }
}

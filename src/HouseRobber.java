/**
 * Created by xhu on 11/21/16.
 */
public class HouseRobber {
    public int rob(int[] nums) {
        if(nums == null || nums.length ==0){
            return 0;
        }

        int first= nums[0];
        int second = Math.max(nums[0],nums[1]);
        int temp = 0;
        for(int i = 2; i<nums.length;i++){
            temp = Math.max(first+nums[i],second);
            first = second;
            second =  temp;
        }

        return Math.max(first,second);
    }
}

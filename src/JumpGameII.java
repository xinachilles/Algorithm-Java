/**
 * Created by xhu on 10/28/16.
 */
public class JumpGameII {
       /* public int jump(int[] nums) {
            if(nums == null || nums.length ==0){
                return 0;
            }

            int longest = nums[0];
            int step  = 0;
            for(int i = 1; i<nums.length; i++){
                if(longest>=i && nums[i] + i > longest){
                    longest = nums[i]+i;
                    step++;
                }
            }
            if(longest>=nums.length-1){
                return step;
            }else{
                return Integer.MAX_VALUE;
            }
        }*/

    // jump Game

    public int Jump(int[] nums)
    {
        if (nums == null || nums.length == 0)
        {
            return 0;
        }

        int step = 0;
        int maxLength = nums[0];

        for (int i = 1; i < nums.length; i++)
        {
            if (maxLength >= i && maxLength < nums[i] + i)
            {
                step++;
                maxLength = nums[i] + i;
            }
        }

        return step;
    }

}

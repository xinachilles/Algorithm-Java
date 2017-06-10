/**
 * Created by xhu on 10/21/16.
 */
public class JumpGame {
   /* public boolean canJump(int[] nums) {
        if(nums == null){
            return true;
        }

        boolean[] canJump = new boolean[nums.length];
        // canJump[i] = true means can reach the index i form 0
        canJump[0] = true;

        for(int i = 0; i<nums.length;i++){
            if(canJump[i]) {
                int step = nums[i];

                for (int j = 1; j < step && j<nums.length; j++) {
                    canJump[i + j] = true;
                }
            }
        }

        return canJump[nums.length-1];
    }*/

   public boolean canJump(int[] nums){
       if(nums == null || nums.length ==0){
           return  true;
       }
       int longest = nums[0];
       for(int i = 1; i<nums.length;i++){
           if(longest>=i && nums[i]+i >longest){
               longest = nums[i]+i;
           }
       }

       return longest >= nums.length-1;
   }
}

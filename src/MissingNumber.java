/**
 * Created by xhu on 11/2/16.
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        for(int i  = 0; i<nums.length;i++){
            while(nums[i] >=0 && nums[i]<nums.length && nums[i] != nums[nums[i]]){
                int temp1 = nums[i];
                int temp2 = nums[nums[i]];

                nums[temp1] = temp1;
                nums[i] =  temp2;
            }
        }

        for(int i = 0; i<nums.length; i++){
            if(nums[i] != i){
                return i;
            }
        }

        return nums.length;
    }
}

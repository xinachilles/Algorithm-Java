/**
 * Created by xhu on 12/24/16.
 */
public class FindDuplicateNumber {
    public int findDuplicate(int[] nums) {
        if(nums == null || nums.length ==0 ){
            return 0;
        }

        for(int i = 0; i<nums.length;i++){
            while(nums[i] !=i+1 ){
                if(nums[i] == nums[nums[i]-1]){
                    return nums[i];
                }
                int a = nums[i];
                int b  = nums[nums[i]-1];

                nums[nums[i]-1] = a;
                nums[i]= b;

            }
        }

        return -1;
    }
}

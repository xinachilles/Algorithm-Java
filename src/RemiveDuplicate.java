/**
 * Created by xhu on 10/30/16.
 */
public class RemiveDuplicate {
    //remive duplicate f
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }

        if (nums.length <= 2) {
            return nums.length;
        }

        int index = 1;

        for (int i = 2; i < nums.length; i++) {
            if (nums[index - 1] != nums[i]) {
                nums[++index] = nums[i];
            }
        }

        return index + 1;
    }
}

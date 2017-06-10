/**
 * Created by xhu on 10/23/16.
 */
public class RemoveDuplicatesSortedArray {
    public int removeDuplicates(int[] nums) {

        if (nums == null) {
            return 0;
        }

        if (nums.length == 0) {
            return 0;
        }

        int index = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                nums[++index] = nums[i];
            }
        }

        return index + 1;
    }
}

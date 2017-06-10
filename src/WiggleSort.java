/**
 * Created by xhu on 10/30/16.
 */
public class WiggleSort {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        for (int i = 0; i < nums.length; i++) {


            if (i % 2 == 1 && nums[i] < nums[i - 1]) {
                swap(i, i - 1, nums);
            }

            if (i % 2 == 0 && i > 1 && nums[i] > nums[i - 1]) {
                swap(i, i - 1, nums);
            }
        }
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}

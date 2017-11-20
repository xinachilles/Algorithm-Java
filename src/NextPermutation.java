/**
 * Created by xhu on 7/17/17.
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }

        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] < nums[i] && j >= 0) {
                j--;
            }

            swap(nums, i, j);
        }
        reverse(i, nums.length - 1, nums);

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int i, int j, int[] nums) {
        int start = i;
        int end = j;

        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}

/**
 * Created by xhu on 10/23/16.
 */
public class FindMinimumRotatedSortedArray {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                start = mid;
            }
        }

        return nums[start] < nums[end] ? start : end;
    }

}

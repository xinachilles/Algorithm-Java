/**
 * Created by xhu on 10/29/16.
 */

public class FindPeakElement {
    //find peek
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isPeak(mid, nums)) {
                return mid;
            } else if (nums[mid] < nums[start]) {
                mid = end;
            } else {
                mid = start;
            }
        }

        if (isPeak(start, nums)) {
            return start;
        }

        if (isPeak(end, nums)) {
            return end;
        }

        return -1;
    }

    private boolean isPeak(int index, int[] nums) {
        if (nums.length == 1) {
            return true;
        }

        if (index == 0 && nums[index] > nums[index + 1]) {
            return true;
        }

        if (index == nums.length - 1 && nums[index] > nums[index - 1]) {
            return true;
        }

        return (nums[index + 1] < nums[index] && nums[index - 1] < nums[index]);
    }


}

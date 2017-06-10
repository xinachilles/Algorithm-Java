/**
 * Created by xhu on 1/15/17.
 */
public class KthLargestElementArray {

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        return partition(nums, 0, nums.length - 1, k);
    }

    private int partition(int[] nums, int start, int end, int k) {
       if(start  == end){
           return nums[start];
       }

        int povit = nums[start];
        int lo = start + 1;
        int hi = end;

        while (lo < hi) {
            while (lo < hi && nums[lo] <= povit) {
                lo++;
            }

            while (lo < hi && nums[hi] > povit) {
                hi--;
            }

            if (lo < hi) {
                change(lo, hi, nums);
                lo++;
                hi--;
            }


        }

        change(hi, start, nums);

        if (hi == nums.length - k) {
            return nums[hi];

        } else if (hi < nums.length - k) {
            return partition(nums, hi + 1, end, k);
        } else {
            return partition(nums, start, hi - 1, k - (nums.length - hi));
        }
    }

    private void change(int start, int end, int[] nums) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}

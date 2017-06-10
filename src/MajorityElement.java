/**
 * Created by xhu on 10/23/16.
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int count = 0;
        int majority = nums[0];
        for (int n : nums) {
            if (n == majority) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    majority = n;
                    count = 1;
                }
            }
        }

        return majority;
    }

}

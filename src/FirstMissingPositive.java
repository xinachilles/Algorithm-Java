/**
 * Created by xhu on 10/24/16.
 */

public class FirstMissingPositive {

/*   public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int n : nums) {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }

        int[] counts = new int[max - min + 1];
        for (int n : nums) {
            counts[n - min]++;
        }

        for (int i = 0; i < max - min + 1; i++) {
            if (i + min > 0 && counts[i] == 0) {
                return i + min;
            }
        }

        return counts.length + min + 1;
    }
    */

// another way is the max number shoule less or equal to array length

    public int firstMissingPostive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[nums[i] - 1] = temp;

            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }
}


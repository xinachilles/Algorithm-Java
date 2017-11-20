package FBOA;

public class SquareSort {

    /*
    We're given a sorted array of integers: [-3, -1, 0, 1, 2].
    We want to generate a sorted array of their squares: [0, 1, 1, 4, 9]
    O(n) runtime complexity.
    */

    public int[] square(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];
        int left = 0;
        int right = nums.length - 1;
        int index = right;
        int[] res = new int[nums.length];
        while (left <= right) {
            if (Math.abs(nums[left]) >= Math.abs(nums[right])) {
                nums[index--] = nums[left] * nums[left];
                left++;
            } else if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                nums[index--] = nums[right] * nums[right];
                right--;
            }
        }
        return res;
    }
}

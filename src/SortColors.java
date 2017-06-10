/**
 * Created by xhu on 10/24/16.
 */

public class SortColors {
    // sort colors
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int red = 0;
        int green = 1;
        int blue = 2;


        int start = 0;
        int end = nums.length - 1;
        int i = 0;
        while (i < end) {
            if (nums[i] == red) {
                changeColor(start, i, nums);
                start++;
                i++;
            }

            if (nums[i] == blue) {
                changeColor(end, i, nums);
                end--;
            }

            if (nums[i] == green) {
                i++;
            }


        }
    }

    private void changeColor(int first, int second, int[] nums) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }

}

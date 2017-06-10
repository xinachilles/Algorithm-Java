/**
 * Created by xhu on 12/5/16.
 */
public class WiggleSubsequence {
    /*public int wiggleMaxLength(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        if(nums.length ==1){
            return 1;
        }

        int index = 0;
        int start = 1;
        for(;start<nums.length;start++){
            if(nums[start]!=nums[start-1]){
                break;
            }
        }

        boolean needBig = nums[start]>nums[start-1]? true : false;

        for(int i = start-1;i<nums.length;i++){
            if(nums[index] <nums[i] && !needBig){
                nums[++index] = nums[i];

                needBig  = !needBig;
            }else if(nums[index] >nums[i] && needBig){
                nums[++index] = nums[i];

                needBig = !needBig;
            }
        }

        return index;
    }*/

    // wiggle subsequence
    int max = Integer.MIN_VALUE;

    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        wiggleMaxLengthHelper(nums, 0, 0, 0, Integer.MIN_VALUE);
        return max;
    }

    // if option is 0, next value can be anything,
    // if option < 0 next value should less than previous one
    // if option >0 next value should be greater than previouse one
    private void wiggleMaxLengthHelper(int[] nums, int index, int option, int count, int previous) {

        if (index == nums.length) {
            max = Math.max(count, max);
            return;
        }

        for (int i = index; i < nums.length; i++) {


            if ((option == 0 && previous != nums[i]) || (option < 0 && previous > nums[i]) || (option > 0 && previous < nums[i])) {

                if (option == 0 && previous > Integer.MIN_VALUE) {
                    option = nums[i] - previous;
                }


                wiggleMaxLengthHelper(nums, i + 1, -1 * option, count + 1, nums[i]);

            }
        }

    }

}

/**
 * Created by xhu on 7/15/17.
 */
public class IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {
        int largest = Integer.MIN_VALUE;
        int largest2 = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];

            if (largest < current) {
                largest2 = largest;
                largest = current;
            } else if (largest2 < current) {
                largest2 = current;
            } else {
                return true;
            }

        }

        return false;
    }


}


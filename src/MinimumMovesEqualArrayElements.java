import java.util.Arrays;

/**
 * Created by xhu on 3/9/17.
 */
public class MinimumMovesEqualArrayElements {


// minimum move
//1. find out the all elements in the array is equal or not if not go to step2

//2. find the max value in the array
//3. add other elements by 1
// 4. the number of moving plus one then go to 1


    public int minMoves(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int moves = 0;
            while (true) {

                if (isEquals(nums)) {
                    return moves;
                }
                int max = findMax(nums);

                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] == max) {
                        continue;
                    }

                    nums[i]++;
                }

            }

            // return moves;
    }

    private boolean isEquals(int[] nums) {
        int target = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (target != nums[i]) {
                return false;
            }
        }

        return true;
    }

    private int findMax(int[] nums) {
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
        }

        return max;
    }

}

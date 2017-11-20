package FBOA;

import java.util.Random;

/**
 * Created by xhu on 7/9/17.
 */
public class RandomPick {

    int[] nums;
    Random rnd;

    public RandomPick(int[] nums) {
        this.nums = nums;
        this.rnd = new Random();
    }

    public int pick(int target) {
        int result = -1;
        int count = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >=max) {
                if(nums[i] > max){
                    count = 1;
                    max = nums[i];
                }else{
                    count++;
                }


                if (rnd.nextInt(count) == 0)
                    result = i;
            }
        }

        return result;
    }
}

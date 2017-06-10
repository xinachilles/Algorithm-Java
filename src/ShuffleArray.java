import java.util.Arrays;
import java.util.Random;

/**
 * Created by xhu on 4/23/17.
 */
public class ShuffleArray {
    int[] copyArray;
    int[] originalArray;
    Random random;
    public ShuffleArray(int[] nums) {
        originalArray = Arrays.copyOf(nums, nums.length);
        copyArray = Arrays.copyOf(nums,nums.length);

        random = new Random();

    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return copyArray;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for(int i = originalArray.length-1; i>0;i++){
            int index = random.nextInt  (i+1);

            exchange(originalArray, i, index);
        }

        return originalArray;
    }

    private void exchange(int[] data, int i, int j){
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;

    }
}

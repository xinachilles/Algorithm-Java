import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 11/12/16.
 */
public class BinaryWatch {
    // binary watch
    public List<String> readBinarWatch(int num) {
        List<Integer> hours = new ArrayList<>();
        List<Integer> minutes = new ArrayList<>();
        List<String> result = new ArrayList<>();
        int[] h = {8, 4, 2, 1};
        int[] m = {32, 16, 8, 4, 2, 1};


        for (int i = 0; i <= num; i++) {
            hours = getPermutation(h, i);
            minutes = getPermutation(m, num - i);

            for (int hr : hours) {
                if (hr > 24) {
                    continue;
                }

                for (int min : minutes) {
                    if (min > 60) {
                        continue;
                    }

                    result.add(String.valueOf(hr) + ":" + (min < 10 ? "0" + String.valueOf(min) : String.valueOf(min)));

                }
            }

        }


        return result;


    }

    private List<Integer> getPermutation(int[] nums, int num) {
        List<Integer> result = new ArrayList<>();

        getPermutatinHelper(nums, num, result, 0, 0, 0);

        return result;

    }

    private void getPermutatinHelper(int[] nums, int num, List<Integer> result, int index, int sum, int currentNumber) {
        if (currentNumber == num) {
            result.add(sum);
            return;
        }

        for (int i = index; i < nums.length; i++) {

            getPermutatinHelper(nums, num, result, i + 1, sum + nums[i], currentNumber + 1);


        }
    }
}

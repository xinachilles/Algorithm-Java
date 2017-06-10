import java.util.Stack;

/**
 * Created by xhu on 10/23/16.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return null;
        }

        Stack<Integer> result = new Stack<Integer>();
        int carray = 1;

        for (int i = digits.length - 1; i >= 0; i--) {
            int number = digits[i] + carray;
            carray = number / 10;
            number = number % 10;

            result.push(number);

        }

        if (carray > 0) {
            result.push(carray);
        }

        int[] nums = new int[result.size()];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = result.pop();
        }

        return nums;

    }
}

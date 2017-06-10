import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 11/26/16.
 */
public class PerfectSquares {
    // prefert squares

    public int numSquares(int n) {
        int[] nums = new int[n + 1];
        // nums[i] is the least number of prefect square numbers

        for (int i = 0; i <= n; i++) {
            nums[i] = Integer.MAX_VALUE;
        }
        List<Integer> squares = generateSquareNumber(n);
        nums[1] = 1;

        for (int i = 2; i <= n; i++) {
            // add after first dubug
            // same as combinationsum4
            if (squares.contains(i)) {
                nums[i] = 1;

            } else {

                int num = Integer.MAX_VALUE;
                for (int j = 0; j < i; j++) {
                    if (squares.contains(i - j)) {
                        num = Math.min(num, nums[j] + 1);
                    }
                }

                nums[i] = num;
            }
        }
        return nums[n];
    }

    private List<Integer> generateSquareNumber(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            result.add(i * i);
        }

        return result;
    }

}

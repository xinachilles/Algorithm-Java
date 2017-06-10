import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 10/23/16.
 */
public class SummaryRanges {
    /*public List<String> summaryRange(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        int start = 0;
        int end = 0;
        StringBuilder s = new StringBuilder();
        for (int n : nums) {
            if (n != end + 1) {
                if (start == end) {
                    s.append(start);
                } else {
                    s.append(start).append("->").append(end);
                }

                result.add(s.toString());
                start = n;
                end = n;
            }
        }

        if (start == end) {
            s.append(start);
        } else {
            s.append(start).append("->").append(end);
        }

        result.add(s.toString());

        return result;
    }*/
    // summary ranges
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        int start = nums[0];
        int end = nums[0];

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] != end + 1) {
                result.add(BuildRange(start, end));
                start = nums[i];
                end = nums[i];
            } else {
                end++;
            }
        }

        result.add(BuildRange(start, end));

        return result;
    }

    private String BuildRange(int start, int end) {
        StringBuilder solution = new StringBuilder();
        if (start == end) {
            solution.append(start);
        } else {
            solution.append(start);
            solution.append("->");
            solution.append(end);

        }

        return solution.toString();
    }
}

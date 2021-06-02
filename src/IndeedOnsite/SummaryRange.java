package IndeedOnsite;

import java.util.ArrayList;
import java.util.List;

public class SummaryRange {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        int start = nums[0];
        int end;

        for (int i = 0; i < nums.length; i++) {

            if (i== nums.length-1 || nums[i]+1 != nums[i+1]) {
                end =nums[i];
                result.add(BuildRange(start, end));
                if(i<nums.length-1) start = nums[i+1];

            }
        }



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

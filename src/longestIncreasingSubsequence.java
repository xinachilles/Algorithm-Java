import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 12/10/16.
 */
public class longestIncreasingSubsequence {
    // longest increasing subsequence
    public int lengthOfLIS(int[] nums){
        if (nums == null || nums.length == 0) {
            return 0;
        }


        List<Integer> result = new ArrayList<>();
        // if A[i] < A[0]
        for (int i = 0; i < nums.length; i++) {
            if (result.size() == 0) {
                result.add(nums[i]);
            } else if (nums[i] > result.get(result.size() - 1)) {
                result.add(nums[i]);
            } else {
                // find the smallest element in result larger then A[i]
                int index = BinarySeach(nums[i], result.size() - 1, result);
                result.set(index, nums[i]);
            }
        }

        return result.size();
    }

    private int BinarySeach(int target, int end, List<Integer> result) {
        int start = 0;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (result.get(mid) >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (result.get(start) >= target) {
            return start;
        } else {
            return end;
        }
    }
}

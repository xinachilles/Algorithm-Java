import java.util.*;

/**
 * Created by xhu on 12/15/16.
 */
public class LargestDivisibleSubset {




    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);

        int[] dp = new int[nums.length];

        int[] track = new int[nums.length];
        Arrays.fill(track, -1);
        int maxIndex = 1;
        int maxLength = 1;
        //dp[i] means the largeset divisible susbset from 0 to ith

        dp[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if ((nums[i] % nums[j] == 0 ) && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    track[i] = j;
                }

            }

            if (maxLength < dp[i]) {
                maxLength = dp[i];
                maxIndex = i;

            }
        }


        for (int i = maxIndex; i >= 0 && track[i] != -1; i = track[i]) {
            result.add(nums[i]);
        }


        return result;


    }

}

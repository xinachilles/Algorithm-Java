/**
 * Created by xhu on 12/10/16.
 */
public class longestIncreasingSubsequence {
    // longest increasing subsequence
    public int lengthOFLIS(int[] nums)
    {
        if(nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int ptr = 0;
        for(int i = 1; i < nums.length; i++){
            int pos = binarySearch(dp, 0, ptr, nums[i]);
            if(dp[pos] > nums[i]) dp[pos] = nums[i];
            if(pos > ptr){
                ptr = pos;
                dp[pos] = nums[i];
            }
        }

        return ptr + 1;
    }

    private int binarySearch(int[] dp, int start, int end, int target){
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(target > dp[mid]){
                start = mid;
            } else {
                end = mid;
            }
        }

        // This equality sign is important
        // otherwise it would return wrong insert position
        if(dp[start] >= target) return start;
        if(dp[end] < target) return end + 1;

        return end;
    }
}

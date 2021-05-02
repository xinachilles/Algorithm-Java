import java.util.ArrayDeque;
import java.util.Deque;

public class ConstrainedSubsequenceSum {
    public int constrainedSubsetSum(int[] nums, int k) {
        if(nums ==null || nums.length == 0){
            return 0;
        }
        int[]dp = new int[nums.length];// dp[i] is max subsequence which end with nums[i]
        // dp[i] = max(dp[i-1], d[i-2],.... dp[i-k] ,0) + a[i]

        dp[0] = nums[0];
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(0);
        for(int i =1; i<nums.length;i++){
            while(!deque.isEmpty() && deque.getFirst()< i-k ){
                deque.removeFirst();
            }
            if(!deque.isEmpty())
            dp[i] =Math.max( dp[deque.getFirst()],0) + nums[i];
            while (!deque.isEmpty() && dp[deque.getLast()] <dp[i]){
                deque.removeLast();
            }

            deque.addLast(i);

        }
        return dp[nums.length-1];
    }
}

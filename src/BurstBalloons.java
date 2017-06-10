/**
 * Created by xhu on 11/27/16.
 */
public class BurstBalloons {
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }


        int[] nums2 = new int [nums.length+2];
        int[][] dp = new int[nums2.length][nums2.length];
        nums2[0] = 1;
        nums2[nums2.length-1] = 1;

        for(int i = 1; i<nums2.length-1; i++){
            nums2[i] = nums[i-1];
        }

        return maxCoinsHelper(nums2,dp,1,nums2.length-2);


    }

    private int maxCoinsHelper(int[] nums,int[][] dp, int start, int end){
       if(dp[start][end]!= 0 ) return dp[start][end];

        int max = Integer.MIN_VALUE;
        // i is the last balloon left
        for(int i= start; i<=end; i++){
            int current = nums[start-1]*nums[i]*nums[end+1];
            int left = maxCoinsHelper(nums,dp,start,i-1);
            int right = maxCoinsHelper(nums,dp,i+1,end);
            max = Math.max(current+left+right,max);
        }

        dp[start][end] = max;
        return max;

    }
}


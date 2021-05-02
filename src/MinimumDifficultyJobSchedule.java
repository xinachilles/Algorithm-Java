import java.util.Arrays;

public class MinimumDifficultyJobSchedule {

    public int minDifficulty(int[] jobDifficulty, int d) {
        if(jobDifficulty == null || jobDifficulty.length == 0|| jobDifficulty.length <d){
            return -1;
        }


        int[][] dp = new int[jobDifficulty.length+1][d+1];// dp[i][j] means the minimum difficulty of a job schedule for first i
        // jobs in  j days, dp[i][j] = Min(dp[k][j-1] +  minimum difficulty of( jobDifficulty k+1 to i), k is from 0 to i-1 )
        // k also need great or equal to j-1


        for(int i = 0; i<=jobDifficulty.length; i++) {
            for (int j = 0; j <= d; j++) {
                dp[i][j] = Integer.MAX_VALUE/2;;
            }
        }
        dp[0][0] = 0;
        for(int i = 1; i<=jobDifficulty.length;i++){
            for(int j = 1; j<=d; j++){
                for(int k = j-1; k<i; k++){
                    dp[i][j]= Math.min(dp[k][j-1]+findMax(jobDifficulty,k,i),dp[i][j]);
                }
            }
        }
                return dp[jobDifficulty.length][d];
    }

    private int findMax(int[]jobDifficulty,int start, int end){
        int max = 0;
        for(int i = start;i<=end;i++){
            max = Math.max(jobDifficulty[i],max);
        }
        return max;
    }

}

import java.util.Arrays;

/**
 * Created by xhu on 2/12/17.
 */
public class StoneGame {
    public boolean stoneGame(int[] piles) {
        int length = piles.length;
        int sum = Arrays.stream(piles).sum();
        // dp[i][j] means the total number player 1 will take from index i to index j
        int[][]dp = new int[length][length];

        for(int i = piles.length-1;i>=0;i--){
            for(int j = i; j<=piles.length-1; j++){
                if(i == j){
                    dp[i][j]  = piles[i];
                }else if(i == j-1){
                    dp[i][j] = Math.max(piles[i],piles[j]);
                }else{
                    // if first player take left one
                    int left = Math.min(dp[i+1][j-1],dp[i+2][j])+piles[i];
                    // if first player take right one
                    int right =Math.min(dp[i+1][j-1],dp[i][j-2])+piles[j];
                    dp[i][j] = Math.max(left, right);
                }
            }
        }
        return dp[0][piles.length-1]*2 >= sum;

    }


}

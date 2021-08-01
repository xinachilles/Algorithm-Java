import java.util.Arrays;

public class StoneGameIII {
    class Solution {
        public String stoneGameIII(int[] stoneValue) {
            // Write your code here
            if (stoneValue == null || stoneValue.length == 0) {
                return "Tie";
            }

            // dp[i][j] is the max number of stones a player can get when the first pile is piles[i] and M == j.
            int[] dp = new int[stoneValue.length];
            Arrays.fill(dp,Integer.MIN_VALUE);
            dp[stoneValue.length-1] = stoneValue[stoneValue.length-1];

            for(int i = stoneValue.length-2; i< stoneValue.length; i++){
                int max = Integer.MIN_VALUE;
                int take = 0;
                for(int x =1 ;x<=3; x++){
                    if(i+x-1>=stoneValue.length) break;
                    take += stoneValue[i+x-1];
                    max = Math.max(take - stoneValue[i+x], max);
                }
                dp[i] = max;

            }


            if(dp[0]>0){
                return "Alice";
            }else if (dp[0]<0) {
                return "Bob";
            }else {
                return "Tie";
            }

        }

    }
    }


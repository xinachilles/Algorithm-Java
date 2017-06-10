/**
 * Created by xhu on 11/26/16.
 */
public class ClimbingStairs {

// climbing stair
        public int climStairs(int n)
        {
            if(n<=0){
                return 0;
            }

            int[] dp = new int[n+1];
            // dp[i] the for i steps,  distinct ways can you climb to the top

            dp[0] =1;
            dp[1] = 1;
            dp[2] = 2;
            for(int i = 3;i<=n;i++){
                dp[i]= dp[i-1]+dp[i-2];
            }

            return dp[n];
        }

    }


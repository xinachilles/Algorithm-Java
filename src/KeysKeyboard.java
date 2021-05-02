public class KeysKeyboard {
    public int minSteps(int n) {
        if(n==0){
            return 0;
        }

        int[]dp = new int[n+1];//  for number of i A, the min operation we can get
        // dp[0] =0
        // dp[1] = 0
        for(int i = 2; i<=n;i++){
            dp[i] = i;
            for(int j =2; j<=n/j;j++){
                if(i%j == 0){
                    dp[i] = Math.min(dp[i], dp[j]+1+j-1);
                }
            }
        }
        return dp[n];
    }
}

public class New21Game {
    public double new21Game(int n, int k, int maxPts) {
        if(n<k || n>=k+maxPts) return 1.0;
        int max = maxPts+k-1;
        double[] dp = new double[max+1];
        dp[0] = 1;
        double sum = 1.0;
        for(int i = 1; i<=max;i++){
            dp[i] = sum/maxPts;
            if(i<k) sum+=dp[i]; // move the right boundary to right
            if(i>=maxPts) sum-=dp[i-maxPts]; // move left boundary to right

        }


           double result = 0.0;
           for(int i = k;i<=n;i++){
               result += dp[i];
           }
           return result;
    }
}

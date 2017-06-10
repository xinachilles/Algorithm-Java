/**
 * Created by xhu on 12/24/16.
 */
public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length ==0){
            return 0;
        }
        int[] dp = new int[A.length];
        //dp[i] means number of arithmetic slices from 0 to i

        for(int i = 2; i<dp.length;i++){

            if(dp[i-1]-dp[i-2] == dp[i]-dp[i-1]){
                dp[i] = dp[i-1]+1;
            }else{
                dp[i] = 0;
            }
        }
        int sum = 0;
        for(int i = 0;i<dp.length;i++){
            sum +=dp[i];
        }

        return sum;
    }
}

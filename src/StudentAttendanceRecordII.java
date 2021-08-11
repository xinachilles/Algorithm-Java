import java.util.Arrays;

public class StudentAttendanceRecordII {

    public int checkRecord(int n) {
        double mod = Math.pow(10,9)+7;
        // 3 dimensions : the first dimension is the length of records
        // the 1 dimension second dimension is consecutive l's (0,1,2)
        // third dimension is is there an a or not (0,1)
        double dp[][][] = new double[n][3][2];

        // base case
        dp[1][0][0] = 1; // p
        dp[1][1][0] = 1; // l
        dp[1][0][1] = 1; // a
        // others like dp[1][2][1] == 0 ... dp[1][1][1] = 1 impossible

        for(int i = 1; i<n;i++){
            // state 6: 2 consecLate, has A
            dp[i][2][1] = dp[i-1][1][1] %mod;
            //state 5 2 consecLate, no A
            dp[i][2][0] = dp[i-1][1][0]%mod;
            // state 4 1 consecLate, has A
            dp[i][1][1] = dp[i-1][0][1]%mod;
            // state 3  1 consecLate, no A
            dp[i][1][0] = dp[i-1][0][0]%mod;
            // state 2 no consecLate, has A
            dp[i][0][1] = (dp[i-1][0][0] + dp[i-1][1][0] + dp[i-1][2][0]) % mod + (dp[i-1][0][1] + dp[i-1][1][1] + dp[i-1][2][1]) % mod;
            // state 1 : no consecLate, no A
            dp[i][0][0] = (dp[i-1][0][0] + dp[i-1][1][0] + dp[i-1][2][0]) % mod;


        }
        double result = 0;
        for (int i = 0; i<3; i++){
            for(int j = 0; j<2; j++){
                result+=dp[n-1][i][j];
                result%=mod;
            }
        }

        return (int)(result%mod);

    }


}





